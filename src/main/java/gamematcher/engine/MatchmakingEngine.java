package gamematcher.engine;

import gamematcher.model.GameRequest;
import gamematcher.model.GameSession;
import gamematcher.service.MatchmakingStrategy;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MatchmakingEngine {
    private final Set<GameSession> activeSessions = ConcurrentHashMap.newKeySet();
    private final MatchmakingStrategy strategy;
    private final ExecutorService executorService;

    public MatchmakingEngine(MatchmakingStrategy strategy) {
        this.strategy = strategy;
        this.executorService = Executors.newCachedThreadPool();
    }

    public CompletableFuture<GameSession> processRequestAsync(GameRequest request) {
        return CompletableFuture.supplyAsync(() -> processRequest(request), executorService);
    }

    public synchronized GameSession processRequest(GameRequest request) {
        // Clean up any players from inactive sessions
        request.getPlayers().forEach(p -> {
            if (p.getCurrentSession() != null && !p.getCurrentSession().isActive()) {
                p.getCurrentSession().getPlayers().remove(p);
                p.setCurrentSession(null);
            }
        });

        // Check if any players are still in active games
        if (request.getPlayers().stream().anyMatch(p -> p.getCurrentSession() != null)) {
            throw new IllegalStateException("One or more players are already in a game");
        }

        // Try to find existing session
        Optional<GameSession> matchingSession = strategy.findMatch(request, activeSessions);

        if (matchingSession.isPresent()) {
            GameSession session = matchingSession.get();
            if (session.addPlayers(request.getPlayers())) {
                return session;
            }
        }

        // Create new session
        GameSession newSession = strategy.createNewSession(request);
        if (!newSession.addPlayers(request.getPlayers())) {
            throw new IllegalStateException("Failed to add players to new session");
        }
        activeSessions.add(newSession);
        return newSession;
    }

    public synchronized List<String> getGameStatuses() {
        return activeSessions.stream()
                .map(GameSession::getFormattedStatus)
                .collect(Collectors.toList());
    }

    public synchronized void cleanupCompletedSessions() {
        activeSessions.removeIf(session ->
                session.isActive() && session.getPlayers().isEmpty());
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

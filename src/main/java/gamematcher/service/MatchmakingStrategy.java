package gamematcher.service;

import gamematcher.model.GameRequest;
import gamematcher.model.GameSession;

import java.util.Collection;
import java.util.Optional;

public interface MatchmakingStrategy {
    Optional<GameSession> findMatch(GameRequest request, Collection<GameSession> availableSessions);
    GameSession createNewSession(GameRequest request);
}
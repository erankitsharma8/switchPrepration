package gamematcher.service.impl;

import gamematcher.model.GameRequest;
import gamematcher.model.GameSession;
import gamematcher.model.enums.Enums;
import gamematcher.service.MatchmakingStrategy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StrictWarGameMatchmakingStrategy implements MatchmakingStrategy {
    @Override
    public Optional<GameSession> findMatch(GameRequest request, Collection<GameSession> sessions) {
        List<GameSession> matchingSessions = sessions.stream()
                .filter(s -> !s.isActive())
                .filter(s -> canMergeIntoSession(request, s))
                .sorted(Comparator.comparingInt(s ->
                        ThreadLocalRandom.current().nextInt())) // Randomize selection
                .collect(Collectors.toList());

        if (!matchingSessions.isEmpty()) {
            return Optional.of(matchingSessions.get(0));
        }
        return Optional.empty();
    }

    private boolean canMergeIntoSession(GameRequest request, GameSession session) {
        // Check if any preferred mode matches session's mode
        boolean modeMatches = request.getPreferredModes().stream()
                .anyMatch(mode -> session.matchesMode(mode));

        // Check if any preferred location matches session's location
        boolean locationMatches = request.getPreferredLocations().stream()
                .anyMatch(loc -> session.matchesLocation(loc));

        if (!modeMatches || !locationMatches) {
            return false;
        }

        // Check capacity
        if (session.getPlayers().size() + request.getPlayers().size() >
                session.getMode().getRequiredPlayers()) {
            return false;
        }

        // Check rank compatibility
        if (session.getRequiredRank() != null) {
            if (request.getLevelMatchCriteria() == Enums.LevelMatchCriteria.SAME_RANK) {
                return session.getRequiredRank() == request.getPlayers().iterator().next().getRank();
            }
            return false;
        } else {
            if (request.getLevelMatchCriteria() == Enums.LevelMatchCriteria.SAME_RANK) {
                if (session.getPlayers().isEmpty()) {
                    return true;
                }
                return session.getPlayers().iterator().next().getRank() ==
                        request.getPlayers().iterator().next().getRank();
            }
            return true;
        }
    }

    @Override
    public GameSession createNewSession(GameRequest request) {
        // For FastDraw, prefer CastleTown
        if (request.getPreferredModes().contains(Enums.GameMode.FAST_DRAW) &&
                request.getPreferredLocations().contains(Enums.GameLocation.CASTLE_TOWN)) {
            return new GameSession(
                    UUID.randomUUID().toString(),
                    Enums.GameMode.FAST_DRAW,
                    Enums.GameLocation.CASTLE_TOWN,
                    request.getLevelMatchCriteria() == Enums.LevelMatchCriteria.SAME_RANK ?
                            request.getPlayers().iterator().next().getRank() : null
            );
        }

        // For other modes, select first preferred
        Enums.GameMode mode = request.getPreferredModes().iterator().next();
        Enums.GameLocation location = request.getPreferredLocations().iterator().next();

        return new GameSession(
                UUID.randomUUID().toString(),
                mode,
                location,
                request.getLevelMatchCriteria() == Enums.LevelMatchCriteria.SAME_RANK ?
                        request.getPlayers().iterator().next().getRank() : null
        );
    }
}

package gamematcher.model;

import gamematcher.model.enums.Enums;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class GameSession {
    private final String id;
    private final Enums.GameMode mode;
    private final Enums.GameLocation location;
    private final Set<Player> players;
    private final Enums.Rank requiredRank;
    private boolean isActive;
    private final Object sessionLock = new Object(); // Dedicated lock for thread safety

    public GameSession(String id, Enums.GameMode mode, Enums.GameLocation location,
                       Enums.Rank requiredRank) {
        this.id = id;
        this.mode = mode;
        this.location = location;
        this.requiredRank = requiredRank;
        this.players = ConcurrentHashMap.newKeySet();
        this.isActive = false;
    }

    /**
     * Attempts to add multiple players to the session atomically
     * @param newPlayers Set of players to add
     * @return true if all players were added successfully, false otherwise
     */
    public boolean addPlayers(Set<Player> newPlayers) {
        synchronized (sessionLock) {
            // Check if session can accept these players
            if (isActive || !canAcceptPlayers(newPlayers)) {
                return false;
            }

            // Verify no players are already in this or other sessions
            for (Player player : newPlayers) {
                if (players.contains(player) ||
                        (player.getCurrentSession() != null &&
                                player.getCurrentSession() != this)) {
                    return false;
                }
            }

            // Add all players atomically
            for (Player player : newPlayers) {
                if (player.getCurrentSession() != null) {
                    player.getCurrentSession().removePlayer(player);
                }
                players.add(player);
                player.setCurrentSession(this);
            }

            // Activate session if we reached required players
            if (players.size() >= mode.getRequiredPlayers()) {
                isActive = true;
            }
            return true;
        }
    }

    /**
     * Removes a player from this session
     * @param player The player to remove
     */
    public void removePlayer(Player player) {
        synchronized (sessionLock) {
            if (players.remove(player)) {
                player.setCurrentSession(null);
                if (players.size() < mode.getRequiredPlayers()) {
                    isActive = false;
                }
            }
        }
    }

    /**
     * Checks if the session can accept the new players
     */
    private boolean canAcceptPlayers(Set<Player> newPlayers) {
        // Check capacity
        if (players.size() + newPlayers.size() > mode.getRequiredPlayers()) {
            return false;
        }

        // Check rank compatibility
        if (requiredRank != null) {
            return newPlayers.stream()
                    .allMatch(p -> p.getRank() == requiredRank);
        }
        return true;
    }

    // Matching utilities
    public boolean matchesMode(Enums.GameMode mode) {
        return this.mode == mode;
    }

    public boolean matchesLocation(Enums.GameLocation location) {
        return this.location == location;
    }

    /**
     * Formats the session status for display
     */
    public String getFormattedStatus() {
        String modeName = formatName(mode.name());
        String locationName = formatName(location.name());
        String playersList = players.stream()
                .sorted(Comparator.comparing(Player::getName))
                .map(Player::getName)
                .collect(Collectors.joining(", "));

        if (isActive) {
            return String.format("Playing %s game with players: %s in %s",
                    modeName, playersList, locationName);
        }
        return String.format("Waiting Game with players: %s", playersList);
    }

    // Helper to format enum names (FAST_DRAW -> FastDraw)
    private String formatName(String input) {
        return Arrays.stream(input.split("_"))
                .map(word -> word.substring(0, 1) + word.substring(1).toLowerCase())
                .collect(Collectors.joining());
    }

    // Getters
    public String getId() { return id; }
    public Enums.GameMode getMode() { return mode; }
    public Enums.GameLocation getLocation() { return location; }
    public Set<Player> getPlayers() { return Collections.unmodifiableSet(players); }
    public Enums.Rank getRequiredRank() { return requiredRank; }
    public boolean isActive() { return isActive; }
}

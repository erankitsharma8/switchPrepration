package gamematcher.model;

import gamematcher.model.enums.Enums;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameRequest {
    private final Set<Player> players;
    private final Set<Enums.GameMode> preferredModes;
    private final Set<Enums.GameLocation> preferredLocations;
    private final Enums.LevelMatchCriteria levelMatchCriteria;

    public GameRequest(Set<Player> players, Set<Enums.GameMode> preferredModes,
                       Set<Enums.GameLocation> preferredLocations,
                       Enums.LevelMatchCriteria levelMatchCriteria) {
        this.players = new HashSet<>(players);
        this.preferredModes = new HashSet<>(preferredModes);
        this.preferredLocations = new HashSet<>(preferredLocations);
        this.levelMatchCriteria = levelMatchCriteria;
    }

    public Set<Player> getPlayers() { return Collections.unmodifiableSet(players); }
    public Set<Enums.GameMode> getPreferredModes() { return Collections.unmodifiableSet(preferredModes); }
    public Set<Enums.GameLocation> getPreferredLocations() { return Collections.unmodifiableSet(preferredLocations); }
    public Enums.LevelMatchCriteria getLevelMatchCriteria() { return levelMatchCriteria; }
}

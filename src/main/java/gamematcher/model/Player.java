package gamematcher.model;

import gamematcher.model.enums.Enums;

import java.util.Objects;

import java.util.Objects;

public class Player {
    private final String id;
    private final String name;
    private Enums.Rank rank;
    private GameSession currentSession;

    public Player(String id, String name, Enums.Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Enums.Rank getRank() { return rank; }
    public GameSession getCurrentSession() { return currentSession; }

    public void setRank(Enums.Rank rank) { this.rank = rank; }

    public synchronized void setCurrentSession(GameSession session) {
        if (this.currentSession != null) {
            this.currentSession.removePlayer(this);
        }
        this.currentSession = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

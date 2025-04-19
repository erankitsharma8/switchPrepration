package gamematcher.model.enums;

public class Enums {
    public enum GameMode {
        TWO_V_TWO(4), FAST_DRAW(2), RAID(6);

        private final int requiredPlayers;

        GameMode(int requiredPlayers) {
            this.requiredPlayers = requiredPlayers;
        }

        public int getRequiredPlayers() {
            return requiredPlayers;
        }
    }

    public enum GameLocation {
        CASTLE_TOWN, AIR_BASE, SAVAGE_LAND;
    }

    public enum Rank {
        BRONZE, SILVER, GOLD, PLATINUM, DIAMOND;
    }

    public enum LevelMatchCriteria {
        SAME_RANK, ANY_RANK;
    }
}

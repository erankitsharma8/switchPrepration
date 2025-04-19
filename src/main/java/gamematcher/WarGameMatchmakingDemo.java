package gamematcher;

import gamematcher.engine.MatchmakingEngine;
import gamematcher.model.GameRequest;
import gamematcher.model.GameSession;
import gamematcher.model.Player;
import gamematcher.model.enums.Enums;
import gamematcher.service.MatchmakingStrategy;
import gamematcher.service.impl.StrictWarGameMatchmakingStrategy;

import java.util.*;
import java.util.concurrent.*;


public class WarGameMatchmakingDemo {
    public static void main(String[] args) throws Exception {
        // Create players
        Player player1 = new Player("1", "player1", Enums.Rank.BRONZE);
        Player player2 = new Player("2", "player2", Enums.Rank.BRONZE);
        Player player3 = new Player("3", "player3", Enums.Rank.BRONZE);
        Player player4 = new Player("4", "player4", Enums.Rank.BRONZE);
        Player player5 = new Player("5", "player5", Enums.Rank.SILVER);
        Player player6 = new Player("6", "player6", Enums.Rank.GOLD);
        Player player7 = new Player("7", "player7", Enums.Rank.GOLD);
        Player player8 = new Player("8", "player8", Enums.Rank.PLATINUM);
        Player player9 = new Player("9", "player9", Enums.Rank.DIAMOND);

        // Create matchmaking engine
        MatchmakingStrategy strategy = new StrictWarGameMatchmakingStrategy();
        MatchmakingEngine engine = new MatchmakingEngine(strategy);

        // ===== CASE 1 =====
        System.out.println("=== CASE 1 ===");
        GameRequest requestA = new GameRequest(
                Set.of(player8, player9),
                Set.of(Enums.GameMode.FAST_DRAW),
                Set.of(Enums.GameLocation.CASTLE_TOWN),
                Enums.LevelMatchCriteria.ANY_RANK
        );

        GameSession sessionA = engine.processRequest(requestA);
        System.out.println(sessionA.getFormattedStatus());
        System.out.println();

        // ===== CASE 2 =====
        System.out.println("=== CASE 2 ===");

        // Reset all relevant players
        resetPlayers(engine, player1, player2, player3, player4, player8, player9);

        // Create requests (modified to ensure proper merging)
        GameRequest requestB = new GameRequest(
                Set.of(player1, player2),
                Set.of(Enums.GameMode.TWO_V_TWO),
                Set.of(Enums.GameLocation.AIR_BASE), // Changed to only AirBase
                Enums.LevelMatchCriteria.SAME_RANK
        );

        GameRequest requestC = new GameRequest(
                Set.of(player3),
                Set.of(Enums.GameMode.TWO_V_TWO),
                Set.of(Enums.GameLocation.AIR_BASE),
                Enums.LevelMatchCriteria.SAME_RANK
        );

        GameRequest requestD = new GameRequest(
                Set.of(player4),
                Set.of(Enums.GameMode.TWO_V_TWO),
                Set.of(Enums.GameLocation.AIR_BASE),
                Enums.LevelMatchCriteria.ANY_RANK
        );

        // Process requests with synchronization
        GameSession sessionB = engine.processRequest(requestB);
        Thread.sleep(50); // Small delay to ensure proper sequencing
        GameSession sessionC = engine.processRequest(requestC);
        Thread.sleep(50);
        GameSession sessionD = engine.processRequest(requestD);

        // Verify merging
        if (sessionB == sessionC && sessionC == sessionD) {
            System.out.println(sessionB.getFormattedStatus());
        } else {
            System.out.println("Failed to merge requests:");
            System.out.println("Session B: " + sessionB.getFormattedStatus());
            System.out.println("Session C: " + sessionC.getFormattedStatus());
            System.out.println("Session D: " + sessionD.getFormattedStatus());
        }
        System.out.println();


        // ===== CASE 3 =====
        System.out.println("=== CASE 3 ===");

        // Phase 1: Concurrent request c, d
        System.out.println("Phase 1: Concurrent request c, d");
        player1.setCurrentSession(null);
        player2.setCurrentSession(null);
        player3.setCurrentSession(null);
        player4.setCurrentSession(null);
        engine.cleanupCompletedSessions();

        CompletableFuture<GameSession> futureC = engine.processRequestAsync(requestC);
        CompletableFuture<GameSession> futureD = engine.processRequestAsync(requestD);
        CompletableFuture.allOf(futureC, futureD).join();
        engine.getGameStatuses().forEach(System.out::println);
        System.out.println();

        // Phase 2: Concurrent request a, e
        System.out.println("Phase 2: Concurrent request a, e");
        GameRequest requestE = new GameRequest(
                Set.of(player5, player6, player7),
                Set.of(Enums.GameMode.TWO_V_TWO, Enums.GameMode.RAID),
                Set.of(Enums.GameLocation.SAVAGE_LAND),
                Enums.LevelMatchCriteria.ANY_RANK
        );

        CompletableFuture<GameSession> futureA = engine.processRequestAsync(requestA);
        CompletableFuture<GameSession> futureE = engine.processRequestAsync(requestE);
        CompletableFuture.allOf(futureA, futureE).join();
        engine.getGameStatuses().forEach(System.out::println);
        System.out.println();

        // Phase 3: Request b
        System.out.println("Phase 3: Request b");
        GameSession sessionB2 = engine.processRequest(requestB);
        engine.getGameStatuses().forEach(System.out::println);

        engine.shutdown();
    }

    private static void resetPlayers(MatchmakingEngine engine, Player... players) {
        Arrays.stream(players).forEach(p -> {
            if (p.getCurrentSession() != null) {
                p.getCurrentSession().removePlayer(p);
            }
            p.setCurrentSession(null);
        });
        engine.cleanupCompletedSessions();
    }
}

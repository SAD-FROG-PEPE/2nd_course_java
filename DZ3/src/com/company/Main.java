package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static Map map = new Map(ThreadLocalRandom.current().nextInt(10,20),ThreadLocalRandom.current().nextInt(4,7));
    public static ExecutorService executor = Executors.newCachedThreadPool();
    public static MapDrawer mapDrawer = new MapDrawer();
    public static GameCycle gameCycle = new GameCycle();
    public static List<String> logs = new ArrayList<>();
    public static int numberOfEnemy=ThreadLocalRandom.current().nextInt(2,4);

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        map.generateMap();
        GameLogic.generateWeapons(numberOfEnemy);
        GameLogic.generateArmor(numberOfEnemy);
        GameLogic.generateEnemies(numberOfEnemy);
        GameLogic.showEnemyEquipment(numberOfEnemy);
        GameLogic.generatePerson();
        executor.execute(mapDrawer);
        executor.execute(gameCycle);
        executor.shutdown();
    }

    public static void restartGame() {
        GameCycle.inGame = true;
        executor = Executors.newCachedThreadPool();
        logs.clear();
        map.generateMap();
        GameLogic.generateWeapons(numberOfEnemy);
        GameLogic.generateArmor(numberOfEnemy);
        GameLogic.generateEnemies(numberOfEnemy);
        GameLogic.showEnemyEquipment(numberOfEnemy);
        GameLogic.person.startWalking();
        executor.execute(mapDrawer);
        executor.execute(gameCycle);
        executor.shutdown();
    }
}

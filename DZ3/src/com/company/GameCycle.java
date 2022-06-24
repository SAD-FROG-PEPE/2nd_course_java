package com.company;

import java.util.concurrent.TimeUnit;

public class GameCycle implements Runnable {
    static int round = 1;
    public static boolean inGame = true;

    @Override
    public void run() {
        while (true) {
            if (GameLogic.enemyList.size() == 0) {
                inGame = false;
            }
            if (!inGame) {
                System.out.println("\u001b[38;5;2mРаунд №" + round + " закончился!\u001b[38;5;0m");
                for (String log : Main.logs) {
                    System.out.println(log);
                }
                round++;
                Menu.Start();
                break;
            }
            if (GameLogic.person.getHealth()<1)
            {
                inGame=false;
                System.out.println("\u001b[38;5;9mYOU ARE DEAD \u001b[38;5;0m");
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              //  e.printStackTrace();
            }
        }
    }
}

package com.company;

public class MapDrawer implements Runnable{

    @Override
    public void run() {
        while (true){
            if(!GameCycle.inGame) {
                break;
            }
            Main.map.printMap();
        }
    }
}
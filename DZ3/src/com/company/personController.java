package com.company;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class personController implements Runnable{

    Person person;
    Map map;
    Cell currentCell;

    public personController(Person person, Map map) {
        this.person = person;
        this.map = map;
    }

    @Override
    public void run() {
        currentCell = map.getRender()[1][1];
        currentCell.setSymbol('@');
        while (person.getHealth()>0){
            if(!GameCycle.inGame) {
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
               // e.printStackTrace();
            }
            walk();
        }
    }

    public void walk(){
        if(currentCell.getSymbol() != ' ') {
            currentCell.setSymbol(' ');
        }
        List<Cell> nearCell = map.getNearCells(currentCell);
        Cell nextCurrentCell = nearCell.get(ThreadLocalRandom.current().nextInt(nearCell.size()));
        currentCell = nextCurrentCell;
        currentCell.setSymbol('@');
       if (GameLogic.enemyList.size()==0)
            currentCell.setSymbol(' ');
    }
}
package com.company;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CreatureController implements Runnable{

    Creature creature;
    Map map;
    Cell currentCell;

    public CreatureController(Creature creature, Map map) {
        this.creature = creature;
        this.map = map;
    }

    @Override
    public void run() {
        int x = ThreadLocalRandom.current().nextInt(2, map.getXSize() - 1);
        int y = ThreadLocalRandom.current().nextInt(2, map.getYSize() - 1);
        currentCell = map.getRender()[y][x];
        currentCell.setSymbol(creature.getName().charAt(0));
        while (creature.getHealth()>0){
            if(!GameCycle.inGame) {
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            if(map.checkPerson(currentCell)){
                fight();
                continue;
            }
            walk();
        }
    }

    public void fight(){
        creature.damage(GameLogic.person.getAttack());
        GameLogic.person.damage(creature.getAttack());
        if(GameLogic.person.getHealth()>0){
            GameLogic.person.getPersonController().currentCell.setSymbol(' ');
            Main.executor.shutdownNow();
            if(creature.getHealth()<1)
            {
                Main.logs.add("\u001b[38;5;9m"+creature.getName()+" повержен\u001b[38;5;0m");
                currentCell.setSymbol(' ');
                GameLogic.setNewEquipment(creature);
                Thread.currentThread().interrupt();
                ((Enemy) creature).death();
            }
        }
    }

    public void walk(){
        if(currentCell.getSymbol() != ' ') {
            currentCell.setSymbol(' ');
        }
        List<Cell> nearCell = map.getNearCells(currentCell);
        Cell nextCurrentCell = nearCell.get(ThreadLocalRandom.current().nextInt(nearCell.size()));
        currentCell = nextCurrentCell;
        currentCell.setSymbol(creature.getName().charAt(0));
    }
}

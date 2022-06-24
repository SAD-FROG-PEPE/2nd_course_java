package com.company;

public class Enemy extends Creature {

    CreatureController enemyController = new CreatureController(this, Main.map);

    public Enemy(String name, int health, int baseDamage) {
        super(name, health, baseDamage);
    }

    public void startWalking(){
        Main.executor.execute(enemyController);
    }

    public void death(){
        GameLogic.enemyList.remove(this);
    }
}

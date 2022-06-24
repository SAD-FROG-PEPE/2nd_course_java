package com.company;

public class Creature {
    private String name;
    private int attack,HP;

    public Creature(String name,int HP,int attack)
    {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
    }

    public void damage(int damage){
        this.HP -= damage;
        Main.logs.add(getName() + " получил " + damage + " урона!");
    }

    public String getName() {return name;}
    public int getHealth() {return HP;}
    public int getAttack() {return attack;}

    public void setHP(int HP) {this.HP = HP;}
    public void setAttack(int attack) {this.attack = attack;}

}

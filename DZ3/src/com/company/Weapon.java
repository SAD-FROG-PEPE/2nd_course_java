package com.company;

public class Weapon extends Equipment{
    int attack;
    public Weapon(String _name, int _attack)
    {
        super(_name);
        this.attack=_attack;
    }

    public int getAttack() {return attack;}
}

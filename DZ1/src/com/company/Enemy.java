package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    String name;
    int HP,attack,protectlevel;

    public Enemy(String _name, int _HP,int _attack,int _protectlevel)
    {
        this.name=_name;
        this.HP=_HP;
        this.attack=_attack;
        this.protectlevel=_protectlevel;
    }

    public String getname() {return name;}
}

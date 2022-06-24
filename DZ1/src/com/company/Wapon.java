package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Wapon {
    String name;
    int attack,cost,level;

    public Wapon(String _name, int _attack,int _cost, int _level)
    {
        this.name=_name;
        this.attack=_attack;
        this.cost=_cost;
        this.level=_level;
    }

    public int getcost() {return cost;}
}

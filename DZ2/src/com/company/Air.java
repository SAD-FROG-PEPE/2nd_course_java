package com.company;

public class Air implements Element{

    @Override
    public int getDamage() {
        return 100;
    }

    @Override
    public String getName() {
        return "air";
    }
}

package com.company;

public class Fire implements Element{
    @Override
    public int getDamage() {
        return 150;
    }

    @Override
    public String getName() {
        return "fire";
    }
}

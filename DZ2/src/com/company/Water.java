package com.company;

public class Water implements Element{
    @Override
    public int getDamage() {
        return 20;
    }

    @Override
    public String getName() {
        return "water";
    }
}

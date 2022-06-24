package com.company;

public class Spell <T extends Element>{

    private T element;

    public Spell(T element)
    {
        this.element=element;
    }

    public void castSpell()
    {
        System.out.println(this.element.getDamage());
        System.out.println(this.element.getName());
    }
}

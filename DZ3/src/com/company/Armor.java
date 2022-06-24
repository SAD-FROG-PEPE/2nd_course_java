package com.company;

public class Armor extends Equipment {
    int protect;

    public Armor(String _name, int _protect)
    {
        super(_name);
        this.protect=_protect;
    }

    public int getProtect() {return protect;}
}

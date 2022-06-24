package com.company;

public class Person {
    String name;
    int HP,exppoints,perlevel,attack,protectlevel;

    public Person(String _name, int _HP,int _exppoints,int _perlevel,int _attack,int _protectlevel)
    {
        this.name=_name;
        this.HP=_HP;
        this.exppoints=_exppoints;
        this.perlevel=_perlevel;
        this.attack=_attack;
        this.protectlevel=_protectlevel;
    }

    public int getAttack() {return attack;}

    public void Prove(int lvl)
    {
        if(lvl<=perlevel)
            System.out.println("Succesfully put on");
        else
            System.out.println("Unfortunately your lvl is lower than the weapon's");
    }
}

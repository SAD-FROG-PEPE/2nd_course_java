package com.company;

public class Person extends PandE{
int exp,lvl;

    public Person(String _name, int _HP,int _exppoints,int _perlevel,int _attack,int _protectlevel)
    {
        this.name=_name;
        this.HP=_HP;
        this.exp=_exppoints;
        this.lvl=_perlevel;
        this.attack=_attack;
        this.protectlvl=_protectlevel;
    }
}


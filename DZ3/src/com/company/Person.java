package com.company;

public class Person extends Creature{
    Weapon weapon;
    Armor armor;

    private personController personController = new personController(this, Main.map);

    public Person(String _name, int _HP,int _attack,Weapon weapon,Armor armor)
    {
        super(_name,_HP,_attack);
        this.armor=armor;
        this.weapon=weapon;
    }

    public void setArmor(Armor armor) {this.armor = armor;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public Weapon getWeapon() {return weapon;}
    public Armor getArmor() {return armor;}

    public void startWalking(){
        Main.executor.execute(personController);
    }
    public personController getPersonController() {
        return personController;
    }

    public void getInfo()
    {
        System.out.println("\u001b[38;5;12m---------------Данные об игроке-----------------\u001b[38;5;0m");
        System.out.println("Имя:"+getName()+"\nЗдоровье: "+getHealth()+"\nАтака: "+getAttack()+"\nОружие: "+weapon.getName()+" "+weapon.getAttack()+" атаки\nБроня: "+armor.getName()+" "+armor.getProtect()+" защиты");
    }
}

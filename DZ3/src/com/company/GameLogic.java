package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic
{
    public static List<Enemy> enemyList = new ArrayList<>();
    public static List<Enemy> enemyListtest = new ArrayList<>();
    static String[] enemynames = {"Infected", "Dragon", "Reaper", "Jumper", "Night Hunter", "Mimic", "Ghost", "Brumak", "Necromorph", "Witch"};
    public static List<Weapon> weaponList = new ArrayList<>();
    static String[] weaponnames = {"axe", "machete", "revolver", "pistol", "rifle", "shotgun", "machine gun", "mortar", "brass knuckles", "bazooka"};
    public static List<Armor> armorList = new ArrayList<>();
    public static List<Armor> armorListtest = new ArrayList<>();
    static String[] armornames = {"Skin","Gold","Iron","Diamond","Power"};
    public static Weapon personweapon= new Weapon("no", 0);
    public static Armor armorperson=new Armor("no", 0);
    public static Person person=new Person("Hero",1000,30,personweapon,armorperson);

    public static void generatePerson(){
        person.startWalking();
    }

    public static void generateWeapons(int numberOfEnemy){
        for (int i = 0; i < numberOfEnemy; i++) {
            Weapon weapon = new Weapon(weaponnames[ThreadLocalRandom.current().nextInt(weaponnames.length)], ThreadLocalRandom.current().nextInt(1,50));
            weaponList.add(i,weapon);
        }
    }

    public static void generateArmor(int numberOfEnemy)
    {
        for (int i = 0; i < numberOfEnemy; i++) {
            int choselist=new Random().nextInt(armornames.length);
            switch (choselist)
            {
                case 0:
                    Armor armor=new Armor(armornames[choselist], ThreadLocalRandom.current().nextInt(1,10));
                    armorList.add(i,armor);
                    armorListtest.add(i,armor);
                    break;
                case 1:
                    armor=new Armor(armornames[choselist], ThreadLocalRandom.current().nextInt(10,20));
                    armorList.add(i,armor);
                    armorListtest.add(i,armor);
                    break;
                case 2:
                    armor=new Armor(armornames[choselist], ThreadLocalRandom.current().nextInt(20,30));
                    armorList.add(i,armor);
                    armorListtest.add(i,armor);
                    break;
                case 3:
                    armor=new Armor(armornames[choselist], ThreadLocalRandom.current().nextInt(30,40));
                    armorList.add(i,armor);
                    armorListtest.add(i,armor);
                    break;
                case 4:
                    armor=new Armor(armornames[choselist], ThreadLocalRandom.current().nextInt(40,50));
                    armorList.add(i,armor);
                    armorListtest.add(i,armor);
                    break;
            }
        }
    }

    public static void generateEnemies(int numberOfEnemy){
        for (int i = 0; i < numberOfEnemy; i++) {
            Enemy enemy = new Enemy(enemynames[new Random().nextInt(enemynames.length)], ThreadLocalRandom.current().nextInt(1,20), ThreadLocalRandom.current().nextInt(10));
            enemy.setHP(enemy.getHealth()+armorList.get(i).getProtect());
            enemy.setAttack(enemy.getAttack()+weaponList.get(i).getAttack());
            enemyList.add(i,enemy);
            enemyListtest.add(i,enemy);
            enemy.startWalking();
        }
    }

    public static void showEnemyEquipment(int numberOfEnemy)
    {
        System.out.println("\u001b[38;5;13m----------------Начало боя----------------\u001b[38;5;0m");
        for (int i = 0; i < numberOfEnemy; i++) {
            System.out.println("\u001b[38;5;1mМОНСТР:\u001b[38;5;0m "+enemyList.get(i).getName()+", "+enemyList.get(i).getHealth()+"HP, "+enemyList.get(i).getAttack()+" attack  " +
                    "\u001b[38;5;4mОРУЖИЕ:\u001b[38;5;0m "+weaponList.get(i).getName()+", "+weaponList.get(i).getAttack()+" attack "+
                    "\u001b[38;5;6mБРОНЯ:\u001b[38;5;0m "+armorList.get(i).getName()+", "+armorList.get(i).getProtect()+" protect ");
        }
    }

    public static void setNewEquipment(Creature creature)
    {
        for (int i=0;i<Main.numberOfEnemy;i++)
        {
            if (creature==enemyListtest.get(i))
            {
                if (person.getArmor().getProtect()<armorList.get(i).getProtect())
                {
                    person.setHP(person.getHealth()-person.getArmor().getProtect());
                    person.setArmor(armorList.get(i));
                    person.setHP(person.getHealth()+person.getArmor().getProtect());
                    Main.logs.add("\u001b[38;5;10mГерой преобрел новую броню:"+person.getArmor().getName()+" с защитой="+person.getArmor().getProtect()+", теперь его HP="+person.getHealth()+"\u001b[38;5;0m");
                }
                if (person.getWeapon().getAttack()<weaponList.get(i).getAttack())
                {
                    person.setAttack(person.getAttack()-person.getWeapon().getAttack());
                    person.setWeapon(weaponList.get(i));
                    person.setAttack(person.getAttack()+weaponList.get(i).getAttack());
                    Main.logs.add("\u001b[38;5;10mГерой преобрел новое оружие:"+person.getWeapon().getName()+" с силой урона="+person.getWeapon().getAttack()+", теперь его атака="+person.getAttack()+"\u001b[38;5;0m");
                }
            }
        }
    }
}

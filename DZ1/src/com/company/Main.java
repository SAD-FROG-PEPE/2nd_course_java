package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Person person=new Person("Arthur",100,150,10,3,8);
        Enemy enemy=new Enemy("Troll",80,6,15);
        Wapon weapon =new Wapon("shotgun",10,15,10);

        person.Prove(weapon.level);

        final Random random = new Random();
        String[] enemynames=new String[]{"Infected", "Dragon", "Reaper", "Jumper", "Night Hunter", "Mimic", "Ghost", "Brumak", "Necromorph", "Witch"};
        ArrayList<Enemy> enemyArrayList=new ArrayList<>();
        String[] waponnames=new String[]{"axe", "machete", "revolver", "pistol", "rifle", "shotgun", "machine gun", "mortar", "brass knuckles", "bazooka"};
        ArrayList<Wapon> weaponArrayList =new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            String enemy1=enemynames[random.nextInt(10)];
            int HP= (int) ((Math.random() * 150) + 50);
            int attack=(int) ((Math.random() * 100) + 1);
            int protectlevel=(int) ((Math.random() * 50) + 1);
            enemyArrayList.add(new Enemy(enemy1, HP, attack,protectlevel));
            String wapon2=waponnames[random.nextInt(10)];
            int attack2=(int) ((Math.random() * 100) + 10);
            int cost2= (int) ((Math.random() * 1000) + 1);
            int level2=(int) ((Math.random() * 50) + 1);
            weaponArrayList.add(new Wapon(wapon2, attack2,cost2,level2));
        }
        int i=0;
        for (Enemy enemy1:enemyArrayList)
        {
            i++;
            System.out.println("enemy "+i+"="+enemy1.name+" has "+enemy1.HP+" hp, "+enemy1.attack+" strong, "+enemy1.protectlevel+" lvl");
        }
        System.out.println();
        i=0;
        for (Wapon weapon2 : weaponArrayList)
        {
            i++;
            System.out.println("weapon "+i+"="+ weapon2.name+" has "+ weapon2.attack+" strong, "+ weapon2.cost+" $, "+ weapon2.level+" lvl");
        }
    }
}

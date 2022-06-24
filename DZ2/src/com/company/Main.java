package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        GameLogic.DPS();

        Spell<Air> airSpell=new Spell<>(new Air());
        Spell<Fire> fireSpell=new Spell<>(new Fire());
        Spell<Earth> earthSpell=new Spell<>(new Earth());
        Spell<Water> waterSpell=new Spell<>(new Water());
        Spell<Frezee> frezeSpell=new Spell<>(new Frezee());
        Spell<Ephir> ephirSpell=new Spell<>(new Ephir());

        SpellInventory spellInventory=new SpellInventory();
        spellInventory.addSpell(airSpell);
        spellInventory.addSpell(fireSpell);
        spellInventory.addSpell(earthSpell);

        for (int i=0;i<3;i++) {spellInventory.getSpells().get(i).castSpell();}
    }

    static class GameLogic
    {
        public static void DPS()
        {
            final Random random = new Random();
            String[] personnames=new String[]{"Arthur", "Elsa", "Mario", "Barbara", "Kratos", "Sonic", "Naruto", "Zelda", "Max Payne", "Altair"};
            ArrayList<Person> personArrayList=new ArrayList<>();
            String[] enemynames=new String[]{"Infected", "Dragon", "Reaper", "Jumper", "Night Hunter", "Mimic", "Ghost", "Brumak", "Necromorph", "Witch"};
            ArrayList<Enemy> enemyArrayList=new ArrayList<>();
            String[] weaponnames=new String[]{"axe", "machete", "revolver", "pistol", "rifle", "shotgun", "machine gun", "mortar", "brass knuckles", "bazooka"};
            ArrayList<Weapon> weaponArrayList =new ArrayList<>();
            ArrayList<Boolean> PutOn =new ArrayList<>();

            for (int j=0;j<5;j++)
            {
                String person1=personnames[random.nextInt(10)];
                int HP= (int) ((Math.random() * 200) + 100);
                int attack=(int) ((Math.random() * 50) + 10);
                int exp=(int) ((Math.random() * 100) + 1);
                int  perlvl=(int) ((Math.random() * 100) + 1);
                int protectlevel=(int) ((Math.random() * 100) + 100);
                personArrayList.add(new Person(person1, HP,exp, perlvl,attack,protectlevel));

                String enemy1=enemynames[random.nextInt(10)];
                HP= (int) ((Math.random() * 200) + 100);
                attack=(int) ((Math.random() * 40) + 1);
                protectlevel=(int) ((Math.random() * 80) + 10);
                enemyArrayList.add(new Enemy(enemy1, HP, attack,protectlevel));

                for (int i=1;i<=2;i++)
                {
                    String weapon2=weaponnames[random.nextInt(10)];
                    attack=(int) ((Math.random() * 80) + 10);
                    int cost= (int) ((Math.random() * 1000) + 1);
                    int level=(int) ((Math.random() * 99) + 10);
                    weaponArrayList.add(new Weapon(weapon2, attack,cost,level));
                }
            }

           /* int i=0;
            for (Person person1:personArrayList)
            {
                i++;
                System.out.println("person "+i+"="+person1.name+" has "+person1.HP+" hp, "+person1.exp+" XP,"+person1.lvl+" lvl,"+person1.attack+" strong,"+ person1.protectlvl+" protect lvl");
            }
            System.out.println();
            i=0;
            for (Enemy enemy1:enemyArrayList)
            {
                i++;
                System.out.println("enemy "+i+"="+enemy1.name+" has "+enemy1.HP+" hp, "+enemy1.attack+" strong,"+ enemy1.protectlvl+" protect lvl");
            }
            System.out.println();*/

            int i=0;
            int k=0;
            for (Weapon weapon2:weaponArrayList)
            {
                i++;
                if (i%2==1){
                    System.out.print("PERSON ");
                    if (weaponArrayList.get(i).lvl<=personArrayList.get(k).lvl)
                    {
                        personArrayList.get(k).attack+=weaponArrayList.get(i-1).attack;
                        PutOn.add(k,true);
                    }
                    else {     PutOn.add(k,false);}
                }
                else
                {
                    System.out.print("ENEMY ");
                    enemyArrayList.get(k).attack+=weaponArrayList.get(i-1).attack;
                }
                System.out.println("weapon "+(k+1)+"="+weapon2.name+" has "+weapon2.attack+" strong,"+ weapon2.cost+" $,"+weapon2.lvl+" lvl");
                if (i%2==0){k++;}
            }

            for (int j=1;j<=5;j++)
            {
                k=0;
                System.out.println("------------------------FIGHT "+j+"--------------------------");
                int a=j-1;
                System.out.println("enemy "+j+"="+enemyArrayList.get(a).name+" has "+enemyArrayList.get(a).HP+" hp, "+enemyArrayList.get(a).attack+" strong,"+ enemyArrayList.get(a).protectlvl+" protect lvl");
                System.out.println("person "+j+"="+personArrayList.get(a).name+" has "+personArrayList.get(a).HP+" hp, "+personArrayList.get(a).exp+" XP,"+personArrayList.get(a).lvl+" lvl,"+personArrayList.get(a).attack+" strong,"+ personArrayList.get(a).protectlvl+" protect lvl");
                if (PutOn.get(j-1)) {System.out.println("WEAPON PUT ON THE PERSON");}
                System.out.println();

                while(enemyArrayList.get(a).HP>0 & personArrayList.get(a).HP>0)
                {
                    while (enemyArrayList.get(a).protectlvl>0 & personArrayList.get(a).protectlvl>0)
                    {
                        k++;
                        System.out.println("ROUND "+k);
                        enemyArrayList.get(a).protectlvl-=personArrayList.get(a).attack;
                        personArrayList.get(a).protectlvl-=enemyArrayList.get(a).attack;
                        if (enemyArrayList.get(a).protectlvl<1)
                        {
                            System.out.println("enemy's protect is BROKEN");
                            System.out.println("person's protect now "+personArrayList.get(a).protectlvl);
                        }
                        else if (personArrayList.get(a).protectlvl<1)
                        {
                            System.out.println("person's protect is BROKEN");
                            System.out.println("enemy's protect now "+enemyArrayList.get(a).protectlvl);
                        }
                        else
                        {
                            System.out.println("enemy's protect now "+enemyArrayList.get(a).protectlvl);
                            System.out.println("person's protect now "+personArrayList.get(a).protectlvl);
                        }
                    }
                    while (enemyArrayList.get(a).protectlvl>0)
                    {
                        k++;
                        System.out.println("ROUND "+k);
                        enemyArrayList.get(a).protectlvl-=personArrayList.get(a).attack;
                        personArrayList.get(a).HP-=enemyArrayList.get(a).attack;
                        if (enemyArrayList.get(a).protectlvl<1) {System.out.println("enemy's protect is BROKEN");}
                        else {System.out.println("enemy's protect now "+enemyArrayList.get(a).protectlvl);}
                        System.out.println("person's HP now "+personArrayList.get(a).HP);
                    }
                    while (personArrayList.get(a).protectlvl>0)
                    {
                        k++;
                        System.out.println("ROUND "+k);
                        enemyArrayList.get(a).HP-=personArrayList.get(a).attack;
                        System.out.println("enemy's HP now "+enemyArrayList.get(a).HP);
                        personArrayList.get(a).protectlvl-=enemyArrayList.get(a).attack;
                        if (personArrayList.get(a).protectlvl<1) {System.out.println("person's protect is BROKEN");}
                        else {System.out.println("person's protect now "+personArrayList.get(a).protectlvl);}
                    }
                    k++;
                    System.out.println("ROUND "+k);
                    enemyArrayList.get(a).HP-=personArrayList.get(a).attack;
                    System.out.println("enemy HP now "+enemyArrayList.get(a).HP);
                    personArrayList.get(a).HP-=enemyArrayList.get(a).attack;
                    System.out.println("person HP now "+personArrayList.get(a).HP);
                }
                if (enemyArrayList.get(a).HP<1){System.out.println("                      PERSON "+j+" WIN");}
                else {System.out.println("                       ENEMY "+j+" WIN");}
            }
        }
    }
}

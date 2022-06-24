package com.company;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class CatLover {
    int Age,CatAge,Weight;
    String Name,Surname,Sex,Cat;
    private String[] MaleNames={ "Adam", "Adrian", "Alex", "Andrew", "Benj", "Blake", "Brian", "Carter", "Charles", "Colin"};
    private String[] Surnames={"Adam", "Backer","Black", "Brad","Brown","Brooks","Chapman","Cook","Dick","Dean","Dyson","Fisher","Flem","Gill","Harri","Holmes","Kelly","Jerome","Leman","Mack"};
    private String[] FemaleNames={"Beat", "Bridg", "Brit", "Gloria", "Diana",  "Dora", "Camil", "Caroli", };
    private String[] Sexs={"ж","м"};
    private String[] Cats={"Barsick","Belyash","Chernish","Chaplin","Murka","Markis","Browny","Black","Sergey"};

    public CatLover()
    {
        this.Age= ThreadLocalRandom.current().nextInt(10,100);
        this.CatAge= ThreadLocalRandom.current().nextInt(0,20);
        this.Weight= ThreadLocalRandom.current().nextInt(0,10);
        this.Sex=this.Sexs[ThreadLocalRandom.current().nextInt(this.Sexs.length)];
        if (Sex=="м")
            this.Name=this.MaleNames[ThreadLocalRandom.current().nextInt(this.MaleNames.length)];
        else
            this.Name=this.FemaleNames[ThreadLocalRandom.current().nextInt(this.FemaleNames.length)];
        this.Surname=this.Surnames[ThreadLocalRandom.current().nextInt(this.Surnames.length)];
        this.Cat=this.Cats[ThreadLocalRandom.current().nextInt(this.Cats.length)];
    }

    public int getAge() {return Age;}
    public int getCatAge() {return CatAge;}
    public int getWeight() {return Weight;}
    public String getCat() {return Cat;}
    public String getName() {return Name;}
    public String getSex() {return Sex;}
    public String getSurname() {return Surname;}

    public String getInfo(){
            return Name+" "+Surname+"  "+Age+"  "+Sex+"  "+Cat+"  "+CatAge+"  "+Weight;}

}

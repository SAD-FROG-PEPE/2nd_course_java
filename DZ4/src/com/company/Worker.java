package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Worker {
    int Age,Salary,Prize,Duration;
    String Name,Surname,Sex,Cat,Department,Position;

    private String[] MaleNames={ "Adam", "Adrian", "Alexander", "Andrew", "Benjamin", "Blake", "Brian", "Carter", "Charles", "Colin"};
    private String[] Surnames={"Adamson", "Backer","Black", "Bradberry","Brown","Brooks","Chapman","Cook","Dickinson","Dean","Dyson","Fisher","Fleming","Gill","Harrison","Holmes","Kelly","Jerome","Leman","Mackenzie"};
    private String[] FemaleNames={"Beatrice", "Bridget", "Britney", "Gloria", "Diana",  "Dorothy", "Camilla", "Caroline", "Cassandra", "Katherine", "Constance"};
    private String[] Sexs={"ж","м"};
    private String[] Cats={"no cat","Barsick","Belyash","Chernish","Chaplin","Murka","Markis","Browny","Black","Sergey"};
    private String[] Departments={"Transportation","Tourism","Sales","Production","Logistic"};
    private String[] Positions={"CFO","CVO","COO","CIO","CMO","CTO","CSO","CISO","CAO"};

    public Worker()
    {
        this.Age= ThreadLocalRandom.current().nextInt(15,65);
        this.Salary= ThreadLocalRandom.current().nextInt(10000,70000);
        this.Prize= ThreadLocalRandom.current().nextInt(0,50000);
        int testDuration=ThreadLocalRandom.current().nextInt(0,70);
        while (this.Age-testDuration<15)
            testDuration=ThreadLocalRandom.current().nextInt(0,70);
        this.Duration= testDuration;
        this.Sex=this.Sexs[ThreadLocalRandom.current().nextInt(this.Sexs.length)];
        if (Sex=="м")
            this.Name=this.MaleNames[ThreadLocalRandom.current().nextInt(this.MaleNames.length)];
        else
            this.Name=this.FemaleNames[ThreadLocalRandom.current().nextInt(this.FemaleNames.length)];
        this.Surname=this.Surnames[ThreadLocalRandom.current().nextInt(this.Surnames.length)];
        this.Cat=this.Cats[ThreadLocalRandom.current().nextInt(this.Cats.length)];
        this.Department=this.Departments[ThreadLocalRandom.current().nextInt(this.Departments.length)];
        this.Position=this.Positions[ThreadLocalRandom.current().nextInt(this.Positions.length)];
    }

    public int getAge() {return Age;}
    public int getSalary() {return Salary;}
    public int getPrize() {return Prize;}
    public int getDuration() {return Duration;}
    public String getCat() {return Cat;}
    public String getName() {return Name;}
    public String getPosition() {return Position;}
    public String getSex() {return Sex;}
    public String getSurname() {return Surname;}
    public String getDepartment() {return Department;}
    public void setPrize(int prize) {Prize = prize;}


    @Override
    public String toString() {return this.getName()+"\t"+this.getSurname()+"\t"+this.getSex()+"\t"+this.getCat()+"\t"+this.getDepartment()+"\t" +this.getPosition()+"\t"+this.getAge()+"\t"+this.getSalary()+"\t"+this.getPrize()+"\t"+this.getDuration();}
}

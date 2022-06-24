package com.example.dz8;

import java.util.ArrayList;

public class Pet {
    private String name, kind;
    private int age, day,month,year;
    private ArrayList<Vaccine> vaccines ;

    public ArrayList<Vaccine> getVaccines() {return vaccines;}
    public String getName() {return name;}
    public int getAge() {
        return age;
    }
    public String getKind() {
        return kind;
    }
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}

    public void setVaccines(ArrayList<Vaccine> vaccines) {this.vaccines = vaccines;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public void setDay(int day) {this.day = day;}
    public void setMonth(int month) {this.month = month;}
    public void setYear(int year) {this.year = year;}

    @Override
    public String toString() {return this.name;}

    public String output() {
        return "ИМЯ: "+name+"\nВИД: "+kind+"\nВОЗРАСТ: "+age+"\nДАТА: "+day+"/"+month+"/"+year;
    }
}
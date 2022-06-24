package com.company;

import java.util.ArrayList;

public class Employer {
    private String name,surname,lastname,post,city;
    private int day,month,year;
    private ArrayList<Task> task;

    public Employer(String name,String surname,String lastname,int day,int month,int year,String post,String city,ArrayList<Task> task)
    {
        this.name=name;
        this.surname=surname;
        this.lastname=lastname;
        this.day=day;
        this.month=month;
        this.year=year;
        this.post=post;
        this.city=city;
        this.task=task;
    }

    public String getName() {return name;}
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}
    public String getLastname() {return lastname;}
    public String getPost() {return post;}
    public ArrayList<Task> getTask() {return task;}
    public String getSurname() {return surname;}
    public String getCity() {return city;}
    public int getTaskSize(){return getTask().size();}
    public int getTaskDone() {return (int) getTask().stream().filter(task1 -> task1.getStatus()=="done").count();}
}

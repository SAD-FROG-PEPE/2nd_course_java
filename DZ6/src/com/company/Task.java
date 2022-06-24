package com.company;

public class Task {
    private String name,status;
    private int hours,fee;

    public Task(String name,String status,int hours, int fee)
    {
        this.name=name;
        this.status=status;
        this.hours=hours;
        this.fee=fee;
    }

    public String getName() {return name;}
    public int getFee() {return fee;}
    public int getHours() {return hours;}
    public String getStatus() {return status;}
}

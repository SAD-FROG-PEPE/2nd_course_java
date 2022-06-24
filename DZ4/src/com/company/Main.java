package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Worker> workers=new ArrayList<>();
    static String[] Departments={"Transportation","Tourism","Sales","Production","Logistic"};

    public static void main(String[] args) {
    System.out.println("\u001b[38;5;1mNAME\tSURNAME\tSEX\tCAT\tDURATION\tPOSITION AGE\tSALARY\tPRIZE\tDURATION\u001b[38;5;0m");
	for (int i=0;i<20;i++) {workers.add(new Worker());}
        System.out.println("\u001b[38;5;1m================================BEGINING===================================\u001b[38;5;0m");
    workers.forEach(System.out::println);
    System.out.println("\u001b[38;5;1mNAME\tSURNAME\tSEX\tCAT\tDURATION\tPOSITION AGE\tSALARY\tPRIZE\tDURATION\u001b[38;5;0m");
    TaskA();
    TaskB();
    TaskC();
    TaskD();
    System.out.println("\u001b[38;5;1mNAME\tSURNAME\tSEX\tCAT\tDURATION\tPOSITION AGE\tSALARY\tPRIZE\tDURATION\u001b[38;5;0m");
    TaskF();
    TaskG();
    TaskE();
    }

    private static void TaskA()
    {
        System.out.println("\u001b[38;5;2m================================TaskA===================================\u001b[38;5;0m");
        Optional<Worker> max=workers.stream().max(Comparator.comparingInt(Worker::getSalary));
        max.ifPresent(System.out::println);
    }
    private static void TaskB()
    {
        System.out.println("\u001b[38;5;3m================================TaskB===================================\u001b[38;5;0m");
        Optional<Worker> min=workers.stream().min(Comparator.comparingInt(Worker::getSalary));
        min.ifPresent(System.out::println);
    }
    private static void TaskC()
    {
        System.out.println("\u001b[38;5;4m================================TaskC===================================\u001b[38;5;0m");
        workers.stream().sorted(Comparator.comparingInt(Worker::getAge)).filter(worker -> worker.getAge()<50).filter(worker -> worker.getCat()!="no cat").forEach(System.out::println);
    }
    private static void TaskD()
    {
        System.out.println("\u001b[38;5;5m================================TaskD===================================\u001b[38;5;0m");
        workers.stream().sorted(Comparator.comparingInt(Worker::getAge)).filter(worker -> worker.getAge()>=50).filter(worker -> worker.getCat()!="no cat").forEach(System.out::println);
    }
    private static void TaskE()
    {
        System.out.println("\u001b[38;5;6m================================TaskE===================================\u001b[38;5;0m");
        String DEPA=workers.get(ThreadLocalRandom.current().nextInt(0,20)).getDepartment();
        System.out.println(DEPA+"=ОТДЕЛ");
        List<Worker> workerdepartmant=workers.stream().filter(worker -> worker.getDepartment()==DEPA).filter(worker -> worker.getPrize()>0).peek(worker -> worker.setPrize(worker.getPrize()*2)).collect(Collectors.toList());
        workerdepartmant.forEach(System.out::println);
    }
    private static void TaskF()
    {
        System.out.println("\u001b[38;5;10m================================TaskF===================================\u001b[38;5;0m");
        Optional<Worker> salprize=workers.stream().filter(worker -> worker.getSalary()+worker.getPrize()>=100000).findFirst();
        if (salprize.isPresent())
        {
            System.out.println(salprize.get());
            System.out.println(salprize.get().Salary+"+"+salprize.get().Prize+"="+(salprize.get().Salary+salprize.get().Prize)+" наносек");
        }
        else
            System.out.println("КОМПАНИЯ НИЩЕБРОДОВ!!!!");
    }
    private static void TaskG()
    {
        System.out.println("\u001b[38;5;11m================================TaskG===================================\u001b[38;5;0m");
        for (int i=0;i<Departments.length;i++)
        {
            String depart=Departments[i];
            System.out.println(depart+"   "+workers.stream().filter(worker -> worker.getDepartment()==depart).count());
        }
    }
}

package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class View {

    public static void showEmployers()
    {
        System.out.println("\u001b[38;5;4m№           ФИО              Дата рождения    Город      Должность  Кол-во_задач\u001b[38;5;0m");
        for (int i=0;i<GenerateLogic.employers.size();i++)
        {
            Employer employer=GenerateLogic.employers.get(i);
            System.out.println(i+1+" "+employer.getSurname()+" "+employer.getName()+" "+employer.getLastname()+"   "+employer.getDay()+"."+employer.getMonth()+"."+employer.getYear()+"    "+employer.getCity()+"    "+employer.getPost()+"      "+employer.getTask().size());
        }
    }

    public static void showTasks()
    {
        for (int i=0;i<GenerateLogic.employers.size();i++)
        {
            System.out.println("\u001b[38;5;2mЗадания работника "+(i+1)+" ("+GenerateLogic.employers.get(i).getSurname()+" "+GenerateLogic.employers.get(i).getName()+" "+GenerateLogic.employers.get(i).getLastname()+"): \u001b[38;5;0m");
            ArrayList<Task> task=GenerateLogic.employers.get(i).getTask();
            System.out.println("\u001b[38;5;34m  № Название Статус Гонорар Часы\u001b[38;5;0m");
            for (int j=0;j<task.size();j++)
                System.out.println("  "+(j+1)+" "+task.get(j).getName()+"     "+task.get(j).getStatus()+"   "+task.get(j).getFee()+"    "+task.get(j).getHours());
        }
    }

    public static void Top3()
    {
        GenerateLogic.employers.stream().sorted(Comparator.comparingInt(Employer::getTaskDone).reversed()).limit(3).forEach(employer -> System.out.println("\u001b[38;5;5m"+employer.getSurname()+" "+employer.getName()+" "+employer.getLastname()+"\u001b[38;5;0m (всего "+employer.getTaskSize()+" заданий, из них выполнено "+employer.getTaskDone()+")"));
    }

    public static void HighFee()
    {
        Optional<Task> task1=GenerateLogic.employers.get(0).getTask().stream().max(Comparator.comparingInt(Task::getFee));
        int j=0;
        for (int i=0;i<GenerateLogic.employers.size();i++)
        {
           Optional<Task> task= GenerateLogic.employers.get(i).getTask().stream().max(Comparator.comparingInt(Task::getFee));
           if (task.get().getFee()>task1.get().getFee())
           {
               task1=task;
               j=i;
           }
        }
        System.out.println("\u001b[38;5;14m"+GenerateLogic.employers.get(j).getSurname()+" "+GenerateLogic.employers.get(j).getName()+" "+GenerateLogic.employers.get(j).getLastname()+"\u001b[38;5;0m  задание "+task1.get().getName()+" с гонораром "+task1.get().getFee());
    }

    public static int checkCorrectness(int min, int max)
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Log.writeInto("[“View”][“checkCorrectness”] Пользователь ввёл следующие данные:"+number);
        while (number <min || number >max)
        {
            System.out.print("Такое число не корректно\nВведите новое число: ");
            number =scanner.nextInt();
            Log.writeInto("[“View”][“checkCorrectness”] Пользователь ввёл следующие данные:"+number);
        }
        return number;
    }

    public static void Read(String nameOfFile)
    {
        try(FileReader reader = new FileReader(nameOfFile))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            Log.writeInto("[“View”][“Read”] Произошла ошибка, см. описание: "+ex.getStackTrace());
            System.out.println(ex.getMessage());
        }
    }
}

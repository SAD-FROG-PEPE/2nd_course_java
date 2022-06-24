package com.company;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args)
    {
        Thread savelog=new Thread(new AutoSaveLogWorker());
        savelog.start();

        System.out.println(new Date());
        int countOfEmployers= ThreadLocalRandom.current().nextInt(3,10);
        for (int i=0;i<countOfEmployers;i++)
            GenerateLogic.generateEmployer(i);
        View.showEmployers();
        View.showTasks();
        MainMenu.Start();
    }
}

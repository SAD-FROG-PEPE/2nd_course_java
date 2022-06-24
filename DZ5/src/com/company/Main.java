package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Thread.sleep;

public class Main {
    static ArrayList<CatLover> catLovers=new ArrayList<>();
    static NewCatLovers newCatLovers;

    public static void main(String[] args)  throws InterruptedException {
        System.out.println("\u001b[38;5;1m№ NAME SURNAME AGE SEX CAT CATAGE WEIGHT\u001b[38;5;0m");
        int a=5;
       String[] myArray = new String[a];
        for (int i=0;i<a;i++) {
            catLovers.add(new CatLover());
            myArray[i]=catLovers.get(i).getName();
            System.out.println(i+1+" "+catLovers.get(i).getInfo());
        }
        //ArrayIndexOutOfBoundsException(a,myArray);

        //IOExceptionORNullPointerException(a,catLovers);

       // IndexOutOfBoundsException();

       /* int rand= ThreadLocalRandom.current().nextInt(1,10);
        newCatLovers = new NewCatLovers(new CatLover(),catLovers,rand);	//Создание потока
        newCatLovers.start();
       sleep(rand*1001);*/

    }

    public static void ArrayIndexOutOfBoundsException(int _a,String[] myArray)
    {
        System.out.println("\u001b[38;5;2m==============================ArrayIndexOutOfBoundsException==========================\u001b[38;5;0m");
        System.out.println("Имена кошатников:");
        for (int i=0;i<_a+1;i++)
        {
           try {
               System.out.print(myArray[i]+" ");
           }
           catch (ArrayIndexOutOfBoundsException e)
           {
               System.out.println();
               System.out.println("Кошатники закончились");
           }
        }
    }
    public static void IndexOutOfBoundsException()
    {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\u001b[38;5;5m==============================IndexOutOfBoundsException=========================\u001b[38;5;0m");
            System.out.print("Введите номер кошатника: ");
            int i = sc.nextInt();
            System.out.println("Кошатник под номером "+i+": "+catLovers.get(i-1).getInfo());
        } catch(IndexOutOfBoundsException e) {
            System.out.println("В нашей базе нет столько кошатников хд");
        }
    }
    public static void IOExceptionORNullPointerException(int a,ArrayList<CatLover> catLovers) {
        String[] catLoversNameFiles={null,"1","2","3","4","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        String catLoverFile = catLoversNameFiles[ThreadLocalRandom.current().nextInt(catLoversNameFiles.length)];
        if (catLoverFile!=null)
        {
            try ( FileWriter fileWriter = new FileWriter(catLoverFile);) {
                for (int i = 0; i < a; i++) {
                    fileWriter.write(catLovers.get(i).getInfo() + "\n");
                }
                System.out.println("Файл успешно создан");
            } catch (IOException e) {
                System.out.println("\u001b[38;5;3m======================================IOException=========================================\u001b[38;5;0m");
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("\u001b[38;5;6m======================================NullPointerException=========================================\u001b[38;5;0m");
            System.out.println("Название не должно быть пустым!!!!");
        }
    }
}


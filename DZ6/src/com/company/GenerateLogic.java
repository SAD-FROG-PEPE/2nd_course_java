package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateLogic {
    public static String[] MaleNames={"Александр", "Андрей", "Алексей", "Валерий", "Виталий", "Влад", "Дмитрий", "Давид", "Егор", "Евгений","Максим", "Михаил","Денис", "Данила"};
    public static String[] Surnames={"Иванов","Васильев","Петров","Смирнов", "Михайлов", "Фёдоров", "Соколов", "Яковлев", "Попов", "Андреев", "Алексеев",  "Лебедев", "Степанов"};
    public static String[] FemaleNames={"Анжела", "Анна",  "Валерия", "Варвара", "Диана",  "Евгения", "Екатерина", "Елена", "Елизавета", "Ирина", "Изабелла", "Марина", "Мария", "Марта", "Марьяна"};
    public static String[] LastNames={"Александров", "Алексеев", "Андреев", "Антонов", "Артёмов", "Борисов", "Валентинов","Викторов","Захаров","Иванов","Константинов", "Леонидов","Максимов", "Николаев", "Олегов"};
    public static String[] Sexs={"ж","м"};
    public static String[] Cities={"Амурск","Анапа","Архангельск","Балашиха","Благовещенск", "Владивосток", "Волгоград", "Грозный","Екатеринбург","Зеленоградск", "Калуга", "Иваново", "Киров", "Липецк", "Москва", "Питер"};
    public static String[] Posts={"Сотрудник","Инструктор","Менеджер","Директор","Администратор","Бухгалтер","Управляющий","Ассистент","Консультант"};
    static ArrayList<Employer> employers=new ArrayList<>();

    public static String[] nameOfTask={"hard","medium","easy","special"};
    public static String[] statuses={"done","open"};

    public static void generateEmployer(int i) {
        String Sex = Sexs[ThreadLocalRandom.current().nextInt(Sexs.length)];
        String name ="";
        String surname="";
        String lastname ="";
        int day = 0;
        if (Sex=="м")
        {
             name = MaleNames[ThreadLocalRandom.current().nextInt(MaleNames.length)];
             surname = Surnames[ThreadLocalRandom.current().nextInt(Surnames.length)];
             lastname = LastNames[ThreadLocalRandom.current().nextInt(LastNames.length)]+"ич";
        }
        else
        {
             name = FemaleNames[ThreadLocalRandom.current().nextInt(FemaleNames.length)];
             surname = Surnames[ThreadLocalRandom.current().nextInt(Surnames.length)]+"а";
             lastname = LastNames[ThreadLocalRandom.current().nextInt(LastNames.length)]+"на";
        }
        String city = Cities[ThreadLocalRandom.current().nextInt(Cities.length)];
        String post = Posts[ThreadLocalRandom.current().nextInt(Posts.length)];
        int year=ThreadLocalRandom.current().nextInt(1951,2005);
        int month=ThreadLocalRandom.current().nextInt(1,12);
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day=ThreadLocalRandom.current().nextInt(1,31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day=ThreadLocalRandom.current().nextInt(1,30);
                break;
            case 2:
                if (year%4==0)
                    day=ThreadLocalRandom.current().nextInt(1,29);
                else
                    day=ThreadLocalRandom.current().nextInt(1,28);
                break;
        }
        int numberOfTasks=ThreadLocalRandom.current().nextInt(1,10);
        ArrayList<Task> tasks=new ArrayList<>();
        generateTask(i,numberOfTasks,tasks);
        Employer employer=new Employer(name,surname,lastname,day,month,year,post,city,tasks);
        employers.add(i,employer);
    }

    public static void generateTask(int i,int numberOfTask, ArrayList<Task> tasks)
    {
        for (int j=0; j<numberOfTask;j++)
        {
            String name=nameOfTask[ThreadLocalRandom.current().nextInt(nameOfTask.length)];
            String status=statuses[ThreadLocalRandom.current().nextInt(statuses.length)];
            int hours=ThreadLocalRandom.current().nextInt(1,30);//31*(24-8)=496 hours of work max
            int fee=0;
            if (name.equals("hard"))
                fee=ThreadLocalRandom.current().nextInt(500,1000);
            if (name.equals("medium"))
                fee=ThreadLocalRandom.current().nextInt(100,500);
            if (name.equals("easy"))
                fee=ThreadLocalRandom.current().nextInt(1,100);
            if (name.equals("special"))
                fee=ThreadLocalRandom.current().nextInt(1000,5000);
            fee*=hours;
            Task task=new Task(name,status,hours,fee);
            if (employers.size()>i)
                employers.get(i).getTask().add(task);
            tasks.add(task);
        }
    }
    public static void newTask()
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Какому сотруднику вы ходите дать дополнительное задание?(Введите номер сотрудника) ");
            int i = scanner.nextInt()-1;
            Log.writeInto("[“GenerateLogic”][“newTask”] Пользователь ввёл следующие данные:"+(i+1));
            while (i>=GenerateLogic.employers.size())
            {
                System.out.print("Такого работника не существует, введите другое число: ");
                i = scanner.nextInt()-1;
                Log.writeInto("[“GenerateLogic”][“newTask”] Пользователь ввёл следующие данные:"+(i+1));
            }
            System.out.print("Сколько заданий вы ему дадите? ");
            int numberOfTasks=scanner.nextInt();
            Log.writeInto("[“GenerateLogic”][“newTask”] Пользователь ввёл следующие данные:"+numberOfTasks);
            while (GenerateLogic.employers.get(i).getTask().size()+numberOfTasks>=20)
            {
                System.out.print("Нельзя давать столько много заданий! Работник же жить будет на работе(дайте ему в сумме меньше 20 заданий): ");
                numberOfTasks=scanner.nextInt();
                Log.writeInto("[“GenerateLogic”][“newTask”] Пользователь ввёл следующие данные:"+numberOfTasks);
            }
            ArrayList<Task> tasks=new ArrayList<>();
            GenerateLogic.generateTask(i,numberOfTasks,tasks);
        }
        catch (InputMismatchException e) {
            System.out.println("\u001b[38;5;196mВводите только число!!!\nПовторите вашу попытку\u001b[38;5;0m");
            Log.writeInto("[“GenerateLogic”][“newTask”]  Произошла ошибка, см. описание: "+e.getStackTrace());
            MainMenu.Start();
        }
    }

    public static void createEmployer(int i)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя: ");
        String name =scanner.next();
        Log.writeInto("[“GenerateLogic”][“createEmployer”] Пользователь ввёл следующие данные:"+name);
        System.out.print("Фамилия: ");
        String surname=scanner.next();
        Log.writeInto("[“GenerateLogic”][“createEmployer”] Пользователь ввёл следующие данные:"+surname);
        System.out.print("Отчество: ");
        String lastname =scanner.next();
        Log.writeInto("[“GenerateLogic”][“createEmployer”] Пользователь ввёл следующие данные:"+lastname);
        System.out.print("Город: ");
        String city = scanner.next();
        Log.writeInto("[“GenerateLogic”][“createEmployer”] Пользователь ввёл следующие данные:"+city);
        System.out.print("Должность: ");
        String post = scanner.next();
        Log.writeInto("[“GenerateLogic”][“createEmployer”] Пользователь ввёл следующие данные:"+post);
        try {
            int year=0,day=0,month=0;
            System.out.print("Год рождения: ");
            year=View.checkCorrectness(1951,2005);
            System.out.print("Месяц рождения:");
            month=View.checkCorrectness(1,12);
            System.out.print("День рождения: ");
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day=View.checkCorrectness(1,31);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    day=View.checkCorrectness(1,30);
                    break;
                case 2:
                    if (year%4==0)
                        day=View.checkCorrectness(1,29);
                    else
                        day=View.checkCorrectness(1,28);
                    break;
            }
            ArrayList<Task> tasks=new ArrayList<>();
            int numberOfTasks=ThreadLocalRandom.current().nextInt(1,5);
            generateTask(i,numberOfTasks,tasks);
            Employer employer=new Employer(name,surname,lastname,day,month,year,post,city,tasks);
            employers.add(i,employer);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Попробуйте еще раз только теперь без ошибок");
            Log.writeInto("[“GenerateLogic”][“createEmployer”]  Произошла ошибка, см. описание: "+e.getStackTrace());
            createEmployer(i);
        }
    }
}

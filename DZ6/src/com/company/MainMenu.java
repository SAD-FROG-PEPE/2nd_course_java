package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void Start()  {
        System.out.println("\u001b[38;5;3m-------------------------------------Меню--------------------------------------\u001b[38;5;0m");
        System.out.print("Выбирите, что вы хотите сделать:\n 1. Ввод нового сотрудника вручную \n 2. Добавление сотрудника из случайных данных\n 3. Добавление заданий" +
                "\n 4. Просмотр списка выполненных и открытых заданий\n 5. Вывод топ-3 сотрудников по выполнению заданий в месяц \n 6. Вывод задания с наибольшим гонораром за выполнение" +
                "\n 7. Формирование отчёта о выполненных заданиях за месяц \n 8. Сохранение списка сотрудников в файл\n 9. Просмотр всех сотрудников\nСтрока ввода: ");
       try {
           Scanner scanner = new Scanner(System.in);
           int choose = scanner.nextInt();
           Log.writeInto("[“MainMenu”][“Start”] Пользователь ввёл следующие данные:"+choose);
           switch (choose) {
               case 1:
                    GenerateLogic.createEmployer(GenerateLogic.employers.size());
                    System.out.println("Работник успешно создан!");
                    Start();
                   break;
               case 2:
                   GenerateLogic.generateEmployer(GenerateLogic.employers.size());
                   System.out.println("Работник успешно создан!");
                   Start();
                   break;
               case 3:
                   if (GenerateLogic.employers.size()!=0)
                        GenerateLogic.newTask();
                   else
                       System.out.println("Сначала создайте работников!!!!!");
                   Start();
                   break;
               case 4:
                   View.showTasks();//aaaaaaaaaaaaaaaaaaaaaaaaaaaaa????????
                   Start();
                   break;
               case 5:
                   View.Top3();
                    Start();
                   break;
               case 6:
                    View.HighFee();
                    Start();
                   break;
               case 7:
                    Report.SaveReport();
                   View.Read("Report.txt");
                   Start();
                   break;
               case 8:
                    SaveLoadEmployer.SaveEmployers();
                    View.Read("Employers.txt");
                    Start();
                   break;
               case 9:
                   View.showEmployers();
                   Start();
                   break;
               default:
                   System.out.println("\u001b[38;5;196mВыбирите число от 1 до 9! Другие числа не подходят.\u001b[38;5;0m");
                   Start();
                   break;
           }
       }
       catch (InputMismatchException e) {
           System.out.println("\u001b[38;5;196mВводите только число!!!\u001b[38;5;0m");
           Log.writeInto("[“MainMenu”][“Start”] Произошла ошибка, см. описание: "+e.getStackTrace());
           Start();
       }
    }
}

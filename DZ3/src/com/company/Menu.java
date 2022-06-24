package com.company;
import java.util.Scanner;

public class Menu {
    public static void Start()  {
        System.out.println("\u001b[38;5;3m---------------------Меню-----------------------\u001b[38;5;0m");
        System.out.println("Выбирите:\n 1. Информация о игроке \n 2. Бой");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Строка ввода: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                GameLogic.person.getInfo();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Start();
                break;
            case 2:
                Main.restartGame();
                break;
            default:
                System.out.println("\u001b[38;5;212mВыбирите число 1 или 2!\u001b[38;5;0m");
                Start();
                break;
        }
    }
}

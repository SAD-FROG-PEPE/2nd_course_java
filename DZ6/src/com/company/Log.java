package com.company;

import java.util.ArrayList;

public class Log {

    private static ArrayList<String> logHistory = new ArrayList<>();

    public static void writeInto(String message)
    {
        System.out.println(message);
        logHistory.add(message);
    }
    public static ArrayList<String> getLogHistory() {return logHistory;}
}

package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadEmployer {

    public static void SaveEmployers()
    {
        try(FileWriter writer = new FileWriter("Employers.txt", false))
        {
            writer.write("\u001b[38;5;4m№           ФИО              Дата рождения    Город      Должность  Кол-во_задач\u001b[38;5;0m \n");

            for (int i=0;i<GenerateLogic.employers.size();i++)
            {
                Employer employer=GenerateLogic.employers.get(i);
                writer.write((i+1)+" "+employer.getSurname()+" "+employer.getName()+" "+employer.getLastname()+"   "+employer.getDay()+"."+employer.getMonth()+"."+employer.getYear()+
                        "    "+employer.getCity()+"    "+employer.getPost()+"      "+employer.getTask().size()+"\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            Log.writeInto("[“SaveLoadEmployer”][“SaveEmployers”] Произошла ошибка, см. описание: "+ex.getStackTrace());
            System.out.println(ex.getMessage());
        }
    }
}

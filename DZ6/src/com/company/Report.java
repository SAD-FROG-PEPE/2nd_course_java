package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Report {

    public static void SaveReport()
    {
        try(FileWriter writer = new FileWriter("Report.txt", false))
        {
            writer.write("\u001b[38;5;4mВыполненные задания за месяц: \u001b[38;5;0m \n");
            for (int i=0;i<GenerateLogic.employers.size();i++)
            {
                Employer employer=GenerateLogic.employers.get(i);
                writer.write((i+1)+" "+employer.getSurname()+" "+employer.getName()+" "+employer.getLastname()+"\n");
                for (int j=0;j<employer.getTask().size();j++)
                {
                    if (employer.getTask().get(j).getStatus()=="done")
                        writer.write("   "+employer.getTask().get(j).getName()+" "+employer.getTask().get(j).getFee()+" "+employer.getTask().get(j).getHours()+"\n");
                }
                if (employer.getTask().stream().filter(task -> task.getStatus()=="done").count()==0)
                    writer.write("\u001b[38;5;9m   НЕТ ВЫПОЛНЕННЫХ ЗАДАНИЙ!\u001b[38;5;0m\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            Log.writeInto("[“Report”][“SaveReport”] Произошла ошибка, см. описание: "+ex.getStackTrace());
            System.out.println(ex.getMessage());
        }
    }
}

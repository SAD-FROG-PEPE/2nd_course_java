package com.example.dz8;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class createPetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageField;

    @FXML
    private Button buttonCreate;

    @FXML
    private CheckBox catCheck;

    @FXML
    private TextField dayField;

    @FXML
    private CheckBox dogCheck;

    @FXML
    private TextField monthField;

    @FXML
    private TextField nameField;

    @FXML
    private Label nullFieldLabel;

    @FXML
    private TextField yearField;

    @FXML
    void buttonCreateClicked(ActionEvent event) throws IOException {
        if(nameField.getText().isEmpty() || ageField.getText().isEmpty()|| dayField.getText().isEmpty()|| monthField.getText().isEmpty()
                || yearField.getText().isEmpty())
            nullFieldLabel.setText("Все поля должны быть заполнены!");
        else if (!catCheck.isSelected()&&!dogCheck.isSelected()||catCheck.isSelected()&&dogCheck.isSelected())
            nullFieldLabel.setText("Введите корректный вид животного");
        else
        {
            Pet pet=new Pet();
            ArrayList<Vaccine> vaccines = new ArrayList<>();

            pet.setName(nameField.getText());
            for (int i=1;i<5;i++)
                setCorrectIntegerCreate(i,pet); //1-AGE 2-YEAR 3-MONTH 4-DAY

            if (catCheck.isSelected())
                pet.setKind("Кошка");
            else
                pet.setKind("Собака");

            System.out.println(pet.output());

            for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,pet.getAge()%10+2); i++) {
                int year=ThreadLocalRandom.current().nextInt(pet.getYear(),(new Date()).getYear()+1900);
                int month=ThreadLocalRandom.current().nextInt(1,12);
                int day = generateDate(month,year);

                String randomDate=day+"."+month+"."+year;
                String medicine =Vaccine.medicines[ThreadLocalRandom.current().nextInt(Vaccine.medicines.length)];
                String type =Vaccine.types[ThreadLocalRandom.current().nextInt(Vaccine.types.length)];
                vaccines.add(new Vaccine(randomDate,type,medicine));

                System.out.println((i+1)+" "+vaccines.get(i).getDate()+" "+vaccines.get(i).getType()+" "+vaccines.get(i).getMedicine());
            }

            pet.setVaccines(vaccines);
            ClinicController.pets.add(pet);

            Main m=new Main();
            m.changeScene("hello-view.fxml");
        }
    }

    public void setCorrectIntegerCreate(int number, Pet pet)
    {
        try {
            switch (number)
            {
                case 1:
                    if (Integer.parseInt (ageField.getText())>-1 && Integer.parseInt (ageField.getText())<21)
                        pet.setAge(Integer.parseInt (ageField.getText()));
                    else
                        pet.setAge(ThreadLocalRandom.current().nextInt(0,20));
                    break;
                case 2:
                    if ((Integer.parseInt(yearField.getText())+pet.getAge()>(new Date()).getYear()) || Integer.parseInt(yearField.getText())<1900)
                        pet.setYear((new Date()).getYear()-pet.getAge()+1900);
                    else
                        pet.setYear(Integer.parseInt(yearField.getText()));
                    break;
                case 3:
                    if (Integer.parseInt(monthField.getText())>12 || Integer.parseInt(monthField.getText())<1)
                        pet.setMonth(ThreadLocalRandom.current().nextInt(1,12));
                    else
                        pet.setMonth(Integer.parseInt(monthField.getText()));
                    break;
                case 4:
                    if (Integer.parseInt(dayField.getText())>1 && Integer.parseInt(dayField.getText())<32)
                        pet.setDay(Integer.parseInt(dayField.getText()));
                    else
                        pet.setDay(generateDate(pet.getMonth(),pet.getYear()));
                    break;
            }
        }
        catch (NumberFormatException e)
        {
            switch (number)
            {
                case 1:
                    pet.setAge(ThreadLocalRandom.current().nextInt(0,20));
                    break;
                case 2:
                   pet.setYear((new Date()).getYear()-pet.getAge()+1900);
                case 3:
                    pet.setMonth(ThreadLocalRandom.current().nextInt(1,12));
                    break;
                case 4:
                    pet.setDay(generateDate(pet.getMonth(),pet.getYear()));
                    break;
            }
        }
    }

    public static int generateDate(int month, int year)
    {
        int day=0;
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
        return day;
    }
}

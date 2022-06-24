package com.example.dz8;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ClinicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageField;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonChange;

    @FXML
    private CheckBox catCheck;

    @FXML
    private TableColumn<Vaccine,String> dataVaccine;

    @FXML
    private TextField dayField;

    @FXML
    private CheckBox dogCheck;

    @FXML
    private TextField monthField;

    @FXML
    private TextField nameField;

    @FXML
    private ListView<Pet> nameOfPets;

    @FXML
    private TableColumn<Vaccine,String> nameVaccine;

    @FXML
    private Button renew;

    @FXML
    private TableColumn<Vaccine,String> typeVaccine;

    @FXML
    private Button vaccine;

    @FXML
    private TextField yearField;

    @FXML
    private TableView<Vaccine> tableVaccine;

    static ArrayList<Pet> pets = new ArrayList<>();
    ObservableList<Vaccine> list;

    @FXML
    void AddButtonClicked(ActionEvent event) throws IOException {
        Main secondScene =new Main();
        secondScene.changeScene("createPet.fxml");

        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createPet.fxml"));
        Stage stage1 = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 603, 367);
        stage1.setTitle("Добавление нового животного");
        stage1.setScene(scene);
        stage1.show();*/
    }

    @FXML
    void ChangeButtonClicked(ActionEvent event) {
        Pet nameOfPet=nameOfPets.getSelectionModel().getSelectedItem();

        nameOfPet.setName(nameField.getText());
        for (int i=1;i<5;i++)
            setCorrectIntegerChange(i,nameOfPet); //1-AGE 2-YEAR 3-MONTH 4-DAY

        fillInTable(nameOfPet);

        if (catCheck.isSelected() && !dogCheck.isSelected())
            nameOfPet.setKind(catCheck.getText());
        else if (!catCheck.isSelected() && dogCheck.isSelected())
            nameOfPet.setKind(dogCheck.getText());
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        Pet nameOfPet=nameOfPets.getSelectionModel().getSelectedItem();
        pets.remove(nameOfPet);
        nameOfPets.getItems().remove(nameOfPet);
    }

    @FXML
    void newVaccine(ActionEvent event) {
        Pet nameOfPet=nameOfPets.getSelectionModel().getSelectedItem();

        int year=ThreadLocalRandom.current().nextInt(nameOfPet.getYear(),(new Date()).getYear()+1900);
        int month=ThreadLocalRandom.current().nextInt(1,12);
        int day = createPetController.generateDate(month,year);

        String randomDate=day+"."+month+"."+year;
        String medicine =Vaccine.medicines[ThreadLocalRandom.current().nextInt(Vaccine.medicines.length)];
        String type =Vaccine.types[ThreadLocalRandom.current().nextInt(Vaccine.types.length)];
        nameOfPet.getVaccines().add(new Vaccine(randomDate,type,medicine));

        fillInTable(nameOfPet);
    }

    @FXML
    void onPetClicked(MouseEvent event) {
        Pet nameOfPet=nameOfPets.getSelectionModel().getSelectedItem();

        nameField.setText(nameOfPet.getName());
        ageField.setText(String.valueOf(nameOfPet.getAge()));
        dayField.setText(String.valueOf(nameOfPet.getDay()));
        monthField.setText(String.valueOf(nameOfPet.getMonth()));
        yearField.setText(String.valueOf(nameOfPet.getYear()));

        fillInTable(nameOfPet);

        if (nameOfPet.getKind().equals("Кошка"))
        {
            if (dogCheck.isSelected())
                dogCheck.fire();
            if (!catCheck.isSelected())
                catCheck.fire();
        }
        else
        {
            if (!dogCheck.isSelected())
                dogCheck.fire();
            if (catCheck.isSelected())
                catCheck.fire();
        }
    }

    @FXML
    void renewClicked(ActionEvent event) {
        ObservableList<Pet> elements = FXCollections.observableArrayList();
        elements.addAll(pets);
        nameOfPets.setItems(elements);
    }

    public void fillInTable(Pet nameOfPet)
    {
        list=FXCollections.observableArrayList(nameOfPet.getVaccines());

        dataVaccine.setCellValueFactory(new PropertyValueFactory<>("date"));
        typeVaccine.setCellValueFactory(new PropertyValueFactory<>("type"));
        nameVaccine.setCellValueFactory(new PropertyValueFactory<>("medicine"));

        tableVaccine.setItems(list);
    }

    public void setCorrectIntegerChange(int number, Pet pet)
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
                        pet.setDay(createPetController.generateDate(pet.getMonth(),pet.getYear()));
                    break;
            }
        }
        catch (NumberFormatException ignored) {}
    }
}

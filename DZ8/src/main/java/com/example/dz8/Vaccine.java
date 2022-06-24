package com.example.dz8;

public class Vaccine {
    private String type,medicine,date;
    public static String[] types={"Аэрозольная","Аэрозольная","Внутримышечная","Внутрикожная","Интраназальная","Конъюнктивальная","Накожная","Пероралъная","Подкожная"};
    public static String[] medicines={"Вангард","Дюрамун","Биовак","Биокан","Вакдерм","Гексадог","Гискан","Глобфел","Эурикан",
            "Квадрикат","Микродерм","Мультикан","Мультифел", "Нобивак","Поливак","Пуревакс" };

    public Vaccine(String date, String type, String medicine)
    {
        this.date=date;
        this.type=type;
        this.medicine=medicine;
    }

    public String getDate() {return date;}
    public String getType() {return type;}
    public String getMedicine() {return medicine;}

    public void setDate(String date) {this.date = date;}
    public void setType(String type) {
        this.type = type;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {return "ДАТА: "+date+"\nТИП: "+type+"\nЛЕКАРСТВО: "+medicine;}
}
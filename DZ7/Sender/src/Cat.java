import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private final int CatAge;
    private final int Weight;
    private final String CatName;

    public Cat()
    {
        this.CatAge= ThreadLocalRandom.current().nextInt(0,20);
        this.Weight= ThreadLocalRandom.current().nextInt(1,10);
        String[] cats = {"Barsick", "Belyash", "Chernish", "Chaplin", "Murka", "Markis", "Browny", "Black", "Sergey"};
        this.CatName= cats[ThreadLocalRandom.current().nextInt(cats.length)];
    }

    public String getCatName() {return CatName;}

    @Override
    public String toString() {return "Имя: " + CatName + "\nВес: " + Weight + "\nВозраст: " + CatAge+"\n------------------------------\n";}
}

package machine;

public class CoffeeVarieties {
    private int number;
    private String name;
    private int water;
    private int milk;
    private int beans;
    private int price;

    public CoffeeVarieties(int number, String name, int water, int milk, int beans, int price) {
        this.number = number;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

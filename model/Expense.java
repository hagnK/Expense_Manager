package model;

public class Expense {
    private final String name;
    private final int price;
    private final String detail;

    public Expense(String name, int price, String note){
        this.name = name;
        this.price = price;
        this.detail = note;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getDetail(){
        return detail;
    }
}

package ru.gb.objects;

public class Product {
    public String name;
    public int id;
    public double price;

    public Product (int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

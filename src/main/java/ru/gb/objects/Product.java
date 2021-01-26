package ru.gb.objects;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public int id;
    public double cost;

    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
}

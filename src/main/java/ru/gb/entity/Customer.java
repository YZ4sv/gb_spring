package ru.gb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", length = 128)
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @ManyToMany(mappedBy = "products")
//    Set<Product> products = new HashSet<>();
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//
//    public Set<Product> getProducts() {
//        return products;
//    }
}

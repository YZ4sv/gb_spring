package ru.gb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select a from Product a")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {

    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "customer_product_relation",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    Set<Customer> customers = new HashSet<>();

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
}

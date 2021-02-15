package ru.gb.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_product_relation")
public class CustomerProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Integer customer_id;
    private Integer product_id;
    private Integer created_at;
    private Integer product_price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @MapsId("customerId")
    private Customer customer;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "product_id", referencedColumnName = "id")
//    @MapsId("productId")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @OneToOne
    @MapsId("fuckU")
    @JoinColumn(name = "product_id")
    public Product product;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }
}

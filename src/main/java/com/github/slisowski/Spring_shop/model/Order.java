package com.github.slisowski.Spring_shop.model;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int count;
    private double cost;
    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),

            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    private OrderStatus orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

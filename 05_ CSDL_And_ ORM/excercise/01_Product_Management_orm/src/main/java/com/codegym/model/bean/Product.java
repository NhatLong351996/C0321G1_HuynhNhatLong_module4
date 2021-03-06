package com.codegym.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price;
    private String describeProduct;
    private String producer;

    public Product() {
    }

    public Product(String name, Integer price, String describeProduct, String producer) {
        this.name = name;
        this.price = price;
        this.describeProduct = describeProduct;
        this.producer = producer;
    }

    public Product(Integer id, String name, Integer price, String describeProduct, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describeProduct = describeProduct;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describe) {
        this.describeProduct = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

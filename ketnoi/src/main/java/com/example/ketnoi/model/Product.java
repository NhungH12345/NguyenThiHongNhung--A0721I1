package com.example.ketnoi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Không được để trống")
    private String name;
    @NotEmpty(message = "Không được để trống")
    private double price;

    @NotEmpty(message = "Không được để trống")
    private String description;

    //    @ManyToOne(targetEntity = Category.class)
//    private Category category;

    public Product() {
    }

    public Product(Integer id, @NotEmpty(message = "Không được để trống") String name, @NotEmpty(message = "Không được để trống") double price, @NotEmpty(message = "Không được để trống") String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

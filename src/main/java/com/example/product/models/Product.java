package com.example.product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;
    private String description;
    private int price;
    private String image;

    // one product will have only one category
    //1p:1c
    //mp:1c
    @ManyToOne
    private Category category;
}

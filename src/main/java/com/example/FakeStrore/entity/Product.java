package com.example.FakeStrore.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    //this is how our  response looks
    private int Id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}

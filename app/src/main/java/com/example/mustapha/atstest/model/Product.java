package com.example.mustapha.atstest.model;

import java.util.ArrayList;

/**
 * Created by mustapha on 12/12/17.
 */

public class Product {

    private String productName;
    private String basePrice;
    private String imageUrl;
    private String category;
    private String brand;
    private String productMaterial;
    private String details;
    private String delivery;

    private ArrayList<Review> reviews;

    public Product (){};

    public Product(String productName, String basePrice, String imageUrl, String category,
                   String brand, String productMaterial, String details, String delivery, ArrayList<Review> reviews) {
        this.productName = productName;
        this.basePrice = basePrice;
        this.imageUrl = imageUrl;
        this.category = category;
        this.brand = brand;
        this.productMaterial = productMaterial;
        this.details = details;
        this.delivery = delivery;
        this.reviews = reviews;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}

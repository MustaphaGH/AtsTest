package com.example.mustapha.atstest.model;

/**
 * Created by mustapha on 12/12/17.
 */

public class Review {


    private Number ratingAmount;

    private String reviewContent;

    private Product product;

    public Review(){};

    public Review(Number ratingAmount, String reviewContent, Product product) {
        this.ratingAmount = ratingAmount;
        this.reviewContent = reviewContent;
        this.product = product;
    }

    public Number getRatingAmount() {
        return ratingAmount;
    }

    public void setRatingAmount(Number ratingAmount) {
        this.ratingAmount = ratingAmount;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

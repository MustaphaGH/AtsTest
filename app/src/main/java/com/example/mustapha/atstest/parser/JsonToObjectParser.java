package com.example.mustapha.atstest.parser;

import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.model.Review;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mustapha on 12/12/17.
 */

public class JsonToObjectParser {


    public static ArrayList<Product> getProductsList(JSONArray parentArray) {


        ArrayList<Product> products = new ArrayList<>();

        try {



            if (parentArray.length() > 0) {

                for (int i = 0; i < parentArray.length(); i++) {


                    JSONObject jData = parentArray.getJSONObject(i);

                    Product product = new Product();

                    product.setProductName(jData.getString("productName"));
                    product.setBasePrice(jData.getString("basePrice"));

                    product.setCategory(jData.getString("category"));
                    product.setBrand(jData.getString("brand"));

                    product.setProductMaterial(jData.getString("productMaterial"));
                    product.setImageUrl(jData.getString("imageUrl"));

                    product.setDelivery(jData.getString("delivery"));
                    product.setDetails(jData.getString("details"));

                    JSONArray jsonObjectReviews = jData.getJSONArray("reviews");

                    ArrayList<Review> reviews = getReviewsList(jsonObjectReviews);
                    for (Review review: reviews) {
                        review.setProduct(product);
                    }

                    product.setReviews(reviews);

                    products.add(product);
                }
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


        return products;
    }




    public static ArrayList<Review> getReviewsList(JSONArray parentArray) {


        ArrayList<Review> reviews = new ArrayList<>();

        try {



            if (parentArray.length() > 0) {

                for (int i = 0; i < parentArray.length(); i++) {


                    JSONObject jData = parentArray.getJSONObject(i);

                    Review review = new Review();
                    review.setRatingAmount(jData.getDouble("rating"));
                    review.setReviewContent(jData.getString("content"));

                    reviews.add(review);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return reviews;
    }


}

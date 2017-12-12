package com.example.mustapha.atstest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mustapha.atstest.R;
import com.example.mustapha.atstest.adapter.ReviewListAdapter;
import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.model.Review;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by mustapha on 12/12/17.
 */

public class ProductDetail extends AppCompatActivity {


    public static Product currentProduct;

    private CircularImageView productImage;
    private TextView brand,productMaterials,details;

    private ListView reviewsListViews;
    private ArrayList<Review> dataItems = new ArrayList<>();
    private ReviewListAdapter reviewListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_detail);

        reviewsListViews = findViewById(R.id.reviewsListView);
        brand = findViewById(R.id.productBrand);
        details = findViewById(R.id.productDetail);
        productMaterials = findViewById(R.id.productMaterial);


        brand.setText("Brand : "+currentProduct.getBrand());
        productMaterials.setText("Materials : "+currentProduct.getProductMaterial());
        details.setText("Details : "+currentProduct.getDetails());

        initAdapter();

    }



    public void initAdapter(){

        dataItems = currentProduct.getReviews();
        reviewListAdapter = new ReviewListAdapter(this,R.layout.item_list_reviews,dataItems);
        reviewsListViews.setAdapter(reviewListAdapter);

    }


    public static void startProductDetailActivity(Context caller, Product product){

        currentProduct = product;

        Intent i = new Intent(caller,ProductDetail.class);

        caller.startActivity(i);
    }


}

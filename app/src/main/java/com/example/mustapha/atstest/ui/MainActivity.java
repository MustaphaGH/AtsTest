package com.example.mustapha.atstest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mustapha.atstest.R;
import com.example.mustapha.atstest.adapter.ProductListAdapter;
import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.rest.VolleyCallback;
import com.example.mustapha.atstest.rest.VolleyRequestsHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProductListAdapter productListAdapter;
    ListView productsListView;
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsListView = (ListView) findViewById(R.id.productListView);

        getData();
    }

    public void initAdapter(){
        productListAdapter = new ProductListAdapter(this,R.layout.item_list_product,products);
        productsListView.setAdapter(productListAdapter);
    }

    public void getData(){
        new VolleyRequestsHandler(this).getProductsData(null,
                new VolleyCallback() {
                    @Override
                    public void onSuccess(Object response , Boolean status, String msg) {

                        if(status){
                            products = (ArrayList<Product>) response;
                            initAdapter();
                        }else {
                            String message = (String) response ;
                            Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Object error) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}

package com.example.mustapha.atstest.rest;

import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.model.ResponseModel;
import com.example.mustapha.atstest.parser.JsonToObjectParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mustapha on 12/12/17.
 */

public class VolleyRequestsHandler {


    Activity activity;
    JsonToObjectParser jsonToObjectParser;
    ResponseModel responseModel;


    public VolleyRequestsHandler(Activity activity) {

        this.activity = activity;
        jsonToObjectParser = new JsonToObjectParser();
    }



    public void getProductsData(JSONObject object, final VolleyCallback volleyCallback) {

        StringRequest request = new StringRequest(Request.Method.GET, Urls.productsUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONArray jsonArray = new JSONArray(response);

                                ArrayList<Product> products = JsonToObjectParser.getProductsList(jsonArray);

                                volleyCallback.onSuccess(products, true, "");



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                volleyCallback.onError(error);

            }
        }) ;


        ConnectionSingleton.getInstance(activity).

                addToRequestque(request);

    }










}

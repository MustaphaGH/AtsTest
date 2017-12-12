package com.example.mustapha.atstest.rest;

/**
 * Created by mustapha on 12/12/17.
 */

public interface VolleyCallback {

    void onSuccess(Object response , Boolean status, String message);
    void onError(Object error);

}

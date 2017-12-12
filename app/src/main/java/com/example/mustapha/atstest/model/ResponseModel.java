package com.example.mustapha.atstest.model;

/**
 * Created by mustapha on 12/12/17.
 */

public class ResponseModel {

    private Boolean status;
    private String message;

    public ResponseModel() {
    }

    public ResponseModel(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

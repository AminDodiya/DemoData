package com.example.brevity.retropostdemo.utils;


public interface ApiCallback {
    public void success(String responseData);
    public void failure(String errorMSg);
}

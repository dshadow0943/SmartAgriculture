package com.example.smartagriculture.interfaces;

public interface TokenCallback {

    void getTokenSuccess(String token);

    void getTokenFailed(int code, String msg);

}

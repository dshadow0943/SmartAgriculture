package com.example.smartagriculture.interfaces;

public interface CallBack<K, V> {

    void onSuccess(K data);

    void onFail(V data);

}

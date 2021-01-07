package com.example.smartagriculture.interfaces;

import android.view.View;

public interface AdapterListener<T> {

        void onClickListener(T data, int position);

        void onLongClickListener(T data, int position);
}

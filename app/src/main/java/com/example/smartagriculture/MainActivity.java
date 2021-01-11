package com.example.smartagriculture;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.api.source.local.LocalDataSource;
import com.example.smartagriculture.utils.Utils;
import com.example.smartagriculture.view.activity.HomeActivity;
import com.example.smartagriculture.view.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(this);
        init();
        jump();
        finish();
    }

    private void init(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        SpareData.init();
    }

    private void jump(){

        String token = null;
        token = LocalDataSource.getInstance().getToken();

        if (token == null || token.equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            Log.e("TAG", "jump: " + token);
            SpareData.putStringData(SpareData.TOKEN, token);
            startActivity(new Intent(this, HomeActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        SpareData.destroy();
    }
}


package com.example.smartagriculture.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

public class LoginDialog {

    public static void login(Context context, Class<?> cls){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("你的登录信息已过期,请重新登录")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.startActivity(new Intent(context, cls));
                    }
                }).show();
    }

    public static void loginOut(Context context, Class<?> cls){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("你确认要退出吗？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.startActivity(new Intent(context, cls));
                        ((Activity)context).finish();
                    }
                }).show();
    }

}

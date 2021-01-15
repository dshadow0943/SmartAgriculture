package com.example.smartagriculture.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.LoginContract;
import com.example.smartagriculture.presenter.LoginPresenter;

public class LoginActivity extends ActivityBase<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    private EditText eUserPhone;
    private EditText eUserPwd;

    @Override
    protected int getViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void bindLayout() {
        eUserPhone = findViewById(R.id.login_user_phone);
        eUserPwd = findViewById(R.id.login_user_pwd);
        findViewById(R.id.login_log).setOnClickListener(this);
        findViewById(R.id.login_user_register).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void display() {

    }

    private void login(){
        String phone = eUserPhone.getText().toString();
        if (phone == null || phone.equals("")){
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String pwd = eUserPwd.getText().toString();
        if (pwd == null || pwd.equals("")){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

//        if (phone.length() != 11 || phone.charAt(0) != '1'){
//            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
//            eUserPhone.setText("");
//            eUserPwd.setText("");
//            return;
//        }
        mPresenter.userLogin(phone, pwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_log:
                login();
                break;
            case R.id.login_user_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void loginFailed(String msg) {
        Toast.makeText(this, "登录失败：" + msg, Toast.LENGTH_SHORT).show();
    }
}
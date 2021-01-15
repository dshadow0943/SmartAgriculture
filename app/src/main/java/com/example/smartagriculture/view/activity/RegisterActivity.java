package com.example.smartagriculture.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.RegisterContract;
import com.example.smartagriculture.presenter.RegisterPresenter;
import com.example.smartagriculture.utils.Utils;

public class RegisterActivity extends ActivityBase<RegisterPresenter> implements RegisterContract.View, View.OnClickListener {

    private EditText eName;
    private EditText ePhone;
    private EditText ePwd1;
    private EditText ePwd2;

    @Override
    protected int getViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void bindLayout() {
        eName = findViewById(R.id.register_user_name);
        ePhone = findViewById(R.id.register_user_phone);
        ePwd1 = findViewById(R.id.register_user_pwd);
        ePwd2 = findViewById(R.id.register_user_pwd2);

        findViewById(R.id.register_reg).setOnClickListener(this);
        findViewById(R.id.register_user_name_empty).setOnClickListener(this);
        findViewById(R.id.register_user_phone_empty).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void display() {

    }

    private void register(){

        String name = ePhone.getText().toString();
        if (name == null || name.equals("")){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String phone = ePhone.getText().toString();
        if (phone == null || phone.equals("")){
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd1 = ePwd1.getText().toString();
        if (pwd1 == null || pwd1.equals("")){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd2 = ePwd1.getText().toString();
        if (pwd2 == null || pwd2.equals("")){
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pwd1.equals(pwd2)){
            Toast.makeText(this, "两次输入的密码不一致, 请重新输入", Toast.LENGTH_SHORT).show();
            ePwd2.setText("");
            return;
        }
        eName.setText("");
        ePhone.setText("");
        ePwd1.setText("");
        ePwd2.setText("");
        mPresenter.register(name, phone, pwd1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_reg:
                register();
                break;
            case R.id.register_user_name_empty:
                eName.setText("");
                break;
            case R.id.register_user_phone_empty:
                ePhone.setText("");
        }
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(Utils.getContext(), "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void registerFailed() {
        Toast.makeText(Utils.getContext(), "注册失败", Toast.LENGTH_SHORT).show();
        ePwd1.setText("");
        ePwd2.setText("");
    }
}
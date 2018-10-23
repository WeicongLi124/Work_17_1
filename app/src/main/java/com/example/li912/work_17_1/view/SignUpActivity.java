package com.example.li912.work_17_1.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.li912.work_17_1.R;
import com.example.li912.work_17_1.model.UserBean;
import com.example.li912.work_17_1.other.Tools;

public class SignUpActivity extends AppCompatActivity {
    private RelativeLayout mainLayoutRl;
    private TextView loginTv;
    private EditText nameEdt;
    private EditText mobileEdt;
    private EditText userEdt;
    private EditText pswEdt;
    private Button signBtn;
    private String name;
    private String mobile;
    private String userName;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        Tools.steepStatusBar(this);
        initView();
        initListener();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mainLayoutRl = findViewById(R.id.mainLayout_rl);
        loginTv = findViewById(R.id.signup_login_tv);
        nameEdt = findViewById(R.id.sign_name_edt);
        mobileEdt = findViewById(R.id.sign_mobile_edt);
        userEdt = findViewById(R.id.sign_user_edt);
        pswEdt = findViewById(R.id.sign_psw_edt);
        signBtn = findViewById(R.id.signup_btn);
    }

    /**
     * 定义监听
     */
    private void initListener() {
        mainLayoutRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mainLayoutRl.requestFocus();
                Tools.hideSoftInput(SignUpActivity.this);
                return false;
            }
        });
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkText()) {
                    Toast.makeText(SignUpActivity.this, "something is not true", Toast.LENGTH_LONG).show();
                } else {
                    UserBean.user.setName(name);
                    UserBean.user.setMobile(mobile);
                    UserBean.user.setUserName(userName);
                    UserBean.user.setPassword(password);
                    Toast.makeText(SignUpActivity.this, "SIGN UP", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    /**
     * 检测EditText是否为空
     *
     * @return
     */
    private boolean checkText() {
        name = nameEdt.getText().toString();
        mobile = mobileEdt.getText().toString();
        userName = userEdt.getText().toString();
        password = pswEdt.getText().toString();
        if (name.equals("") || mobile.equals("") || userName.equals("") || password.equals(""))
            return false;
        else return true;
    }

}

package com.example.li912.work_17_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        steepStatusBar();
        initView();
        initListener();
    }

    /**
     * 初始化控件
     */
    private void initView(){
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
    private void initListener(){
        mainLayoutRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mainLayoutRl.requestFocus();
                hideSoftInput();
                return false;
            }
        });
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkText()){
                    Toast.makeText(SignUpActivity.this,"something is not true", Toast.LENGTH_LONG).show();
                }else {
                    UserBean.user.setName(name);
                    UserBean.user.setMobile(mobile);
                    UserBean.user.setUserName(userName);
                    UserBean.user.setPassword(password);
                    Toast.makeText(SignUpActivity.this,"SIGN UP", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    /**
     * 检测EditText是否为空
     * @return
     */
    private boolean checkText(){
        name = nameEdt.getText().toString();
        mobile = mobileEdt.getText().toString();
        userName = userEdt.getText().toString();
        password = pswEdt.getText().toString();
        if (name.equals("")||mobile.equals("")||userName.equals("")||password.equals(""))
            return false;
        else return true;
    }

    /**
     * 开启沉浸式
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * 收起软键盘
     */
    public void hideSoftInput(){
        // 收起键盘
        View view = this.getWindow().peekDecorView();// 用于判断虚拟软键盘是否是显示的
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}

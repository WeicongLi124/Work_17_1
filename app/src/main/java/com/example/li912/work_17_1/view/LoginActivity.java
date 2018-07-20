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

/**
 * @author: Frank
 * @time: 2018/4/13 09:04
 * @e-mail: 912220261@qq.com
 * Function:
 */
public class LoginActivity extends AppCompatActivity {
    private RelativeLayout mainLayoutRl;
    private TextView signTv;
    private EditText userEdt;
    private EditText pswEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
        initListener();
        Tools.steepStatusBar(this);
    }

    /**
     * 初始化控件
     */
    private void initView(){
        mainLayoutRl = findViewById(R.id.mainLayout_rl);
        signTv = findViewById(R.id.login_signUp_tv);
        userEdt = findViewById(R.id.login_user_edt);
        pswEdt = findViewById(R.id.login_psw_edt);
        loginBtn = findViewById(R.id.login_btn);
    }

    /**
     * 定义监听
     */
    private void initListener(){
        mainLayoutRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mainLayoutRl.requestFocus();
                Tools.hideSoftInput(LoginActivity.this);
                return false;
            }
        });
        signTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userEdt.getText().toString().equals("")&&!pswEdt.getText().toString().equals("")
                        &&userEdt.getText().toString().equals(UserBean.user.getUserName())
                        &&pswEdt.getText().toString().equals(UserBean.user.getPassword())){
                    Toast.makeText(LoginActivity.this,"LOGIN", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"something is not true", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

package com.example.li912.work_17_1.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.li912.work_17_1.adapter.MyListAdapter;
import com.example.li912.work_17_1.R;
import com.example.li912.work_17_1.model.TitleBean;
import com.example.li912.work_17_1.model.UserBean;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private List<TitleBean> titleBeans;
    private MyListAdapter adapter;
    private TextView titleTv;
    private ImageButton plusBtn;
    private ImageButton reduceBtn;
    private int num = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        setData();
        initView();
        initListener();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        listView = findViewById(R.id.list_list);
        titleTv = findViewById(R.id.tools_title);
        plusBtn = findViewById(R.id.tools_plus);
        reduceBtn = findViewById(R.id.tools_reduce);
        titleTv.setText(UserBean.user.getName());
        adapter = new MyListAdapter(this,titleBeans);
        listView.setAdapter(adapter);
    }

    /**
     * 定义监听
     */
    private void initListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"the number "+position+" item", Toast.LENGTH_LONG).show();
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                titleBeans.add(new TitleBean("number "+num+" title","the number "+num+" subtitle"));
                adapter.notifyDataSetChanged();
                listView.setSelection(adapter.getCount()-1);
            }
        });
        reduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleBeans.isEmpty())
                    Toast.makeText(ListActivity.this,"data is null", Toast.LENGTH_LONG).show();
                else{
                    titleBeans.remove(0);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(0);
                }
            }
        });
    }

    /**
     * 添加数据
     */
    private void setData(){
        titleBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            num = i;
            titleBeans.add(new TitleBean("number "+i+" title","the number "+i+" subtitle"));
        }
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
}

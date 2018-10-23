package com.example.li912.work_17_1.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
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
    private void initView() {
        listView = findViewById(R.id.list_list);
        titleTv = findViewById(R.id.tools_title);
        plusBtn = findViewById(R.id.tools_plus);
        reduceBtn = findViewById(R.id.tools_reduce);
        titleTv.setText(UserBean.user.getName());
        adapter = new MyListAdapter(this, titleBeans);
        listView.setAdapter(adapter);
    }

    /**
     * 定义监听
     */
    private void initListener() {
        plusBtn.setOnClickListener(this);
        reduceBtn.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "the number " + position + " item", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 添加数据
     */
    private void setData() {
        titleBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            num = i;
            titleBeans.add(new TitleBean("number " + i + " title", "the number " + i + " subtitle"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tools_plus:
                num++;
                titleBeans.add(new TitleBean("number " + num + " title", "the number " + num + " subtitle"));
                adapter.notifyDataSetChanged();
                listView.setSelection(adapter.getCount() - 1);
                break;
            case R.id.tools_reduce:
                if (titleBeans.isEmpty())
                    Toast.makeText(ListActivity.this, "data is null", Toast.LENGTH_LONG).show();
                else {
                    titleBeans.remove(0);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(0);
                }
                break;
        }
    }
}

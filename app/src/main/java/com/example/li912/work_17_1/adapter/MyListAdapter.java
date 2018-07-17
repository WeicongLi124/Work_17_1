package com.example.li912.work_17_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.li912.work_17_1.R;
import com.example.li912.work_17_1.model.TitleBean;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<TitleBean> titleBeans;

    public MyListAdapter(Context context, List<TitleBean> titleBeans){
        this.context = context;
        this.titleBeans = titleBeans;
    }

    @Override
    public int getCount() {
        return titleBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return titleBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            viewHolder.avatarImg = convertView.findViewById(R.id.item_avatar);
            viewHolder.titleTv = convertView.findViewById(R.id.item_title);
            viewHolder.subTitleTv = convertView.findViewById(R.id.item_sub_title);
            convertView.setTag(viewHolder);
        }else viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.avatarImg.setImageResource(R.drawable.avatar);
        viewHolder.titleTv.setText(titleBeans.get(position).getTitle());
        viewHolder.subTitleTv.setText(titleBeans.get(position).getSubTitle());
        return convertView;
    }

    class ViewHolder{
        ImageView avatarImg;
        TextView titleTv;
        TextView subTitleTv;
    }
}

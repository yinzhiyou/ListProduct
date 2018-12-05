package com.example.yinzhiyou20181204.denglu.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinzhiyou20181204.denglu.R;
import com.example.yinzhiyou20181204.denglu.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.DataBean> mData;

    public DataAdapter(Context context) {
        this.context = context;
        mData=new ArrayList<>();
    }

    public void setmData(List<NewsBean.DataBean> data) {
        mData.clear();
        if (data!=null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addData(List<NewsBean.DataBean> data){
        if (data!=null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public NewsBean.DataBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            holder=new ViewHolder(convertView);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.bindData(position);
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            imageView=view.findViewById(R.id.image);
            textView=view.findViewById(R.id.text_news);
            view.setTag(this);
        }
        public void bindData(int position){
            textView.setText(mData.get(position).getAuthor_name());
            ImageLoader.getInstance().displayImage(mData.get(position).getThumbnail_pic_s(),imageView);
        }
    }
}

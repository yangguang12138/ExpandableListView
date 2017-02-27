package com.example.ios_onion.myapplication1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ios_onion on 2017/2/24.
 */

public class ListViewAdapter extends BaseAdapter {

    private  Context context;
    private  List data;

    public ListViewAdapter() {
        super();
    }

    public ListViewAdapter(Context context, List data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewlayout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convertView.setBackgroundColor(Color.rgb(255,0,0));
        return convertView;
    }

    private final class ViewHolder{
        TextView textView;
    }
}

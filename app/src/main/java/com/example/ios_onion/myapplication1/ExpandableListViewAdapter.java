package com.example.ios_onion.myapplication1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ios_onion on 2017/2/24.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Activity activity;
    private List<List<String>> childArray;

    public  ExpandableListViewAdapter(Activity a,List data)
    {
        this.activity = a;
        this.childArray = data;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.layout_children,parent,false);
        }

        TextView tv = (TextView)convertView.findViewById(R.id.tv);
        String str = this.childArray.get(groupPosition).get(childPosition);
        tv.setText(str);

        return convertView;
    }

    //子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public int getGroupCount() {
        return childArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    //hasStableIds()为真，该函数返回的ID必须是固定不变的
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        Object object = childArray.get(groupPosition).get(childPosition);
        return object;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {

        return childArray.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            convertView = LayoutInflater.from(activity).inflate(R.layout.layout_parent,parent,false);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.tv_parent);
        String str = childArray.get(groupPosition).get(0);

        tv.setText(str);

        return convertView;
    }



}

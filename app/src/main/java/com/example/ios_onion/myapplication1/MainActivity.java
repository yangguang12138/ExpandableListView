package com.example.ios_onion.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private ListView lv_list;
    private ExpandableListView listView;
    private ExpandableListViewAdapter expandableListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.ex_listView);

        //表头
        View headerView = LayoutInflater.from(this).inflate(R.layout.listviewheader,null);
        listView.addHeaderView(headerView);
        //表尾
        View footerView = LayoutInflater.from(this).inflate(R.layout.listviewfooterview,null);
        listView.addFooterView(footerView);

        expandableListViewAdapter = new ExpandableListViewAdapter(this,getData());
        listView.setAdapter(expandableListViewAdapter);

        int count = getData().size();

        //1.将所有的group全部展开
        for (int i = 0;i < count;i ++)
        {
            listView.expandGroup(i);
        }
        //2.不能点击收缩
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

        //3.点击每一项的事件
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return true;
            }
        });

        //4.设置箭头不显示
        listView.setGroupIndicator(null);
        //5.修改箭头的图标
        listView.setGroupIndicator(getResources().getDrawable(R.drawable.ic_launcher1));
        //6.长按
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                Log.d("onCreateContexMenu","adf");
            }
        });


        //ListView
//        ListViewAdapter adapter = new ListViewAdapter(this,new ArrayList());
//        lv_list.setAdapter(adapter);
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,getListMap(),
//                R.layout.listviewlayout,new String[]{"title","image"},new int[]{R.id.tv,R.id.iv_onionNum});
//        listView.setAdapter(simpleAdapter);

        //ExpandableListView



    }

    private List<List<String>> getData()
    {
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> childList = new ArrayList<String>();
        childList.add("item1");
        childList.add("item2");
        childList.add("item3");
        childList.add("item4");
        list.add(childList);

        List<String> childList1 = new ArrayList<String>();
        childList1.add("item5");
        childList1.add("item6");
        childList1.add("item7");
        childList1.add("item8");
        list.add(childList1);

        List<String> childList2 = new ArrayList<String>();
        childList2.add("item9");
        childList2.add("item10");
        childList2.add("item11");
        list.add(childList2);

        return list;
    }

    private List<Map<String,Object>> getListMap()
    {
        List<Map<String,Object>> list = new ArrayList();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("title","title1");
        map.put("image",R.drawable.ic_launcher1);
        list.add(map);
        list.add(map);

        return list;
    }


}

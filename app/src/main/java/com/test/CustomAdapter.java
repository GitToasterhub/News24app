package com.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.*;
import com.test.Pojo.*;


public class CustomAdapter extends BaseAdapter implements Serializable {
    List<Item> list;
    LayoutInflater inflater;

    public CustomAdapter(Context context,List<Item> list){
        this.list=list;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return (Item)list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            view=inflater.inflate(R.layout.rowlayout,parent,false);
        }
        TextView title=(TextView) view.findViewById(R.id.title);
        TextView date=(TextView) view.findViewById(R.id.date) ;
        date.setText(list.get(position).getDate());
        title.setText(list.get(position).getTitle());
        WebView webView=(WebView) view.findViewById(R.id.webView);
        webView.loadData(getImage(list.get(position)),"text/html",null);
        
        return view;
    }
    public String getImage(Item item){
        int end=item.getDescription().indexOf('>');
        String img=item.getDescription().substring(0,end+1);
        return img;
    }

}

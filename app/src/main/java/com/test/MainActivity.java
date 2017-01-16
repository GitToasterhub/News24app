package com.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.test.Pojo.Item;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends Activity  {
    StringBuilder response=new StringBuilder();
    XMLParser parser;
    ListView listView;
    CustomAdapter adapter;
    List<Item> list;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
        parser=new XMLParser();
        new RequestTask().execute();

    }



    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            StringBuilder res=new StringBuilder();
            try {
                res = parser.requestGet();
                response = res;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //Do anything with response..
            parser.formatXML(response);
            try {
                list = parser.deSerialize(response).getNews();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            adapter=new CustomAdapter(context,list);

            listView.setAdapter(adapter);
            listView.setClickable(true);

           listView.setOnItemClickListener(new OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   String content;
                   Item item=(Item)list.get(position);
                   content="<h1>"+item.getTitle()+"</h1><br>";
                   content+=item.getDescription()+"<br>";

                   Intent intent=new Intent(MainActivity.this,ShowNewsItemActivity.class);
                   intent.putExtra("content",content);
                   startActivity(intent);
               }
           });

        }
    }
}

package com.stele.htectestapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    Class fragmentClass;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TextView textView= (TextView)  findViewById(R.id.textView);

        String url = "https://raw.githubusercontent.com/danieloskarsson/mobile-coding-exercise/master/items.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Item> items=new ArrayList<>();

                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        Item item=new Item(jsonObject.getString("image"),jsonObject.getString("description"),jsonObject.getString("title"));
                        items.add(item);

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                        //textView.setText(e.toString());
                    }
                }

                ((MyApplication) getApplication()).setItems(items);

                fragmentClass = MainFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                    getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MainActivity.this,"Total items: "+items.size(),Toast.LENGTH_LONG).show();
                //textView.setText("Total items: "+items.size());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                //textView.setText(error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }
}

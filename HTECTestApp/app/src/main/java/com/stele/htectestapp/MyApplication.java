package com.stele.htectestapp;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

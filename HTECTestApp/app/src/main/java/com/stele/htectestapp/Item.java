package com.stele.htectestapp;

import java.io.Serializable;

public class Item implements Serializable {
    public String image;
    public String description;
    public String title;

    public Item(){}
    public Item (String image, String description, String title)
    {
        this.image=image;
        this.description=description;
        this.title=title;
    }
}

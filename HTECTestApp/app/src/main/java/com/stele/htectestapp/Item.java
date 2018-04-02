package com.stele.htectestapp;

import java.io.Serializable;

public class Item implements Serializable {
    private String image;
    private String description;
    private String title;

    public Item(){}
    public Item (String image, String description, String title)
    {
        this.image=image;
        this.description=description;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

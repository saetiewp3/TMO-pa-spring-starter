package com.galvanize.tmo.paspringstarter;

import lombok.Data;

public class Book {
    int id;
    String author;
    String title;
    String yearPublished;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}

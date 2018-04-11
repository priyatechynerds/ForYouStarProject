package com.example.priya.foryoustarproject;

import java.util.ArrayList;

/**
 * Created by PRIYA on 3/31/2018.
 */

public class Certificates_Group {

    private String name;
    private ArrayList<Certificates_Child> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Certificates_Child> getItems() {
        return items;
    }

    public void setItems(ArrayList<Certificates_Child> items) {
        this.items = items;
    }


}

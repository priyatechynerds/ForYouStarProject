package com.example.priya.foryoustarproject;

import java.util.ArrayList;

/**
 * Created by PRIYA on 4/1/2018.
 */

public class Teams {
    public String name;
    private String image;
    public ArrayList<String> players=new ArrayList<String>();
    public ArrayList<String> players1=new ArrayList<String>();

    public Teams(String name,String image,ArrayList<String> players){

    }

    public Teams(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }
}

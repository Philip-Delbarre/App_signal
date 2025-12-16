package com.phd.imageapp;

import java.util.ArrayList;
import java.util.List;

public class ListItems {

    private String mobileRef;
    private int price;


    public ListItems (String mobileRef, int price){

        this.mobileRef = mobileRef;
        this.price = price;

    }

    public String getMobileRef ()
        { return this.mobileRef;
        }
    public int getPrice ()
        { return this.price;
        }

    private ListItems getListItems(){
        return this;
    }

     public static class mobilesView {
    }
}

package com.phd.imageapp;


import java.util.List;

public class Applications {

    public String versionLabel;
    private String packageName;

    // Constructor logic here
    public Applications(String versionLabel, String packageName) {

        this.versionLabel = versionLabel;
        this.packageName = packageName;
    }

    public String getVersionLabel() {
        return this.versionLabel ;
    }

    public String getPackageName() {
        return this.packageName ;
    }

}
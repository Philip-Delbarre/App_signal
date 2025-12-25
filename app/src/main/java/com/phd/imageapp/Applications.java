package com.phd.imageapp;


import java.util.List;

public class Applications {

    public String versionLabel;
    private List<String> permissions;

    // Constructor logic here
    public Applications(String versionLabel, List<String> permissions) {

        this.versionLabel = versionLabel;
        this.permissions = permissions;
    }

    public String getVersionLabel() {
        return this.versionLabel;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

}
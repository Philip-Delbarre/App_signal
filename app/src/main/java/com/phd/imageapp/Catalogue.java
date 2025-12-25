package com.phd.imageapp;
import java.util.List;
public class Catalogue {
    private List<Applications> applications;
    public Catalogue (List<Applications> applications) {
            this.applications = applications;
        }


    public List<Applications> getApplications() {
            return this.applications;

    }
}



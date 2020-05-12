package com.rarosu.simpleobservation.common.models;


public class Taxa {
    private final int id;
    private final String scientificName;
    
    public Taxa(int id, String scientificName) {
        this.id = id;
        this.scientificName = scientificName;
    }

    public int getId() {
        return id;
    }

    public String getScientificName() {
        return scientificName;
    }
}

package com.rarosu.simpleobservation.common.models;


public class Taxon {
    private final int id;
    private final String scientificName;
    
    public Taxon(int id, String scientificName) {
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

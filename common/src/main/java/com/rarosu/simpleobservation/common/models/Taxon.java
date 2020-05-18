package com.rarosu.simpleobservation.common.models;


public class Taxon {
    private int id;
    private String scientificName;
    
    /**
     * Used by Hibernate.
     */
    private Taxon() {
    }
    
    public Taxon(int id, String scientificName) {
        this.id = id;
        this.scientificName = scientificName;
    }
    
    /**
     * Used by Hibernate.
     */
    private void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    /**
     * Used by Hibernate.
     */
    private void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
    
    public String getScientificName() {
        return scientificName;
    }
}

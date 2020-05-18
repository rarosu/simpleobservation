package com.rarosu.simpleobservation.common.models;

import java.util.Optional;

public class Taxon {
    private int id;
    private int dyntaxaId;
    private Optional<Taxon> parentTaxon;
    private TaxonRanking ranking;
    private String scientificName;
    private String swedishName;
    
    /**
     * Used by Hibernate.
     */
    private Taxon() {
    }
    
    public Taxon(int id, int dyntaxaId, Optional<Taxon> parentTaxon, TaxonRanking ranking, String scientificName, String swedishName) {
        this.id = id;
        this.dyntaxaId = dyntaxaId;
        this.parentTaxon = parentTaxon;
        this.ranking = ranking;
        this.scientificName = scientificName;
        this.swedishName = swedishName;
    }
    
    public int getId() {
        return id;
    }
    
    private void setId(int id) {
        this.id = id;
    }
    
    
    public int getDyntaxaId() {
        return dyntaxaId;
    }

    private void setDyntaxaId(int dyntaxaId) {
        this.dyntaxaId = dyntaxaId;
    }

    
    public Optional<Taxon> getParentTaxon() {
        return parentTaxon;
    }

    private void setParentTaxon(Optional<Taxon> parentTaxon) {
        this.parentTaxon = parentTaxon;
    }


    public TaxonRanking getRanking() {
        return ranking;
    }

    private void setRanking(TaxonRanking ranking) {
        this.ranking = ranking;
    }
    
    
    public String getScientificName() {
        return scientificName;
    }
    
    private void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
    

    public String getSwedishName() {
        return swedishName;
    }

    private void setSwedishName(String swedishName) {
        this.swedishName = swedishName;
    }
}

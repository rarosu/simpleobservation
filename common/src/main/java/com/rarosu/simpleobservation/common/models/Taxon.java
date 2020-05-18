package com.rarosu.simpleobservation.common.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taxon")
public class Taxon {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "dyntaxa_id")
    private Integer dyntaxaId;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_taxon_id")
    private Taxon parentTaxon;
    
    @Column(name = "ranking")
    @Enumerated
    private TaxonRanking ranking;
    
    @Column(name = "scientific_name")
    private String scientificName;
    
    @Column(name = "swedish_name")
    private String swedishName;
    
    /**
     * Used by Hibernate.
     */
    Taxon() {
    }
    
    public Taxon(Integer id, Integer dyntaxaId, Taxon parentTaxon, TaxonRanking ranking, String scientificName, String swedishName) {
        this.id = id;
        this.dyntaxaId = dyntaxaId;
        this.parentTaxon = parentTaxon;
        this.ranking = ranking;
        this.scientificName = scientificName;
        this.swedishName = swedishName;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getDyntaxaId() {
        return dyntaxaId;
    }

    public void setDyntaxaId(Integer dyntaxaId) {
        this.dyntaxaId = dyntaxaId;
    }
    
    public Taxon getParentTaxon() {
        return parentTaxon;
    }

    public void setParentTaxon(Taxon parentTaxon) {
        this.parentTaxon = parentTaxon;
    }

    public TaxonRanking getRanking() {
        return ranking;
    }

    public void setRanking(TaxonRanking ranking) {
        this.ranking = ranking;
    }
    
    public String getScientificName() {
        return scientificName;
    }
    
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSwedishName() {
        return swedishName;
    }

    public void setSwedishName(String swedishName) {
        this.swedishName = swedishName;
    }
}

package com.rarosu.simpleobservation.common.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "habitat")
public class Habitat {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_habitat_id")
    private Habitat parentHabitat;
    
    @Column(name = "swedish_name")
    private String swedishName;

    /**
     * Used by Hibernate.
     */
    Habitat() {
    }
    
    public Habitat(Integer id, Habitat parentHabitat, String swedishName) {
        this.id = id;
        this.parentHabitat = parentHabitat;
        this.swedishName = swedishName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Habitat getParentHabitat() {
        return parentHabitat;
    }

    public void setParentHabitat(Habitat parentHabitat) {
        this.parentHabitat = parentHabitat;
    }

    public String getSwedishName() {
        return swedishName;
    }

    public void setSwedishName(String swedishName) {
        this.swedishName = swedishName;
    }
}

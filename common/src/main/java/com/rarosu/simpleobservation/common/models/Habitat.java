package com.rarosu.simpleobservation.common.models;

import java.util.Optional;


public class Habitat {
    private int id;
    private Optional<Habitat> parentHabitat;
    private String swedishName;

    /**
     * Used by Hibernate.
     */
    private Habitat() {
    }
    
    public Habitat(int id, Optional<Habitat> parentHabitat, String swedishName) {
        this.id = id;
        this.parentHabitat = parentHabitat;
        this.swedishName = swedishName;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Optional<Habitat> getParentHabitat() {
        return parentHabitat;
    }

    private void setParentHabitat(Optional<Habitat> parentHabitat) {
        this.parentHabitat = parentHabitat;
    }

    public String getSwedishName() {
        return swedishName;
    }

    private void setSwedishName(String swedishName) {
        this.swedishName = swedishName;
    }
}

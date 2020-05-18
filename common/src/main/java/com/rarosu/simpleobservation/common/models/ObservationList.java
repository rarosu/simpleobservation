package com.rarosu.simpleobservation.common.models;

import java.time.OffsetDateTime;
import java.util.Optional;


public class ObservationList {
    private int id;
    private double longitude;
    private double latitude;
    private Precision precision;
    private Optional<String> locationName;
    private String listName;
    private Optional<String> privateComment;
    private Optional<String> publicComment;
    private OffsetDateTime creationDateTime;
    private Optional<OffsetDateTime> observationDateTime;
    private Optional<Habitat> habitat;
    private Optional<String> habitatDescription;

    /**
     * Used by Hibernate.
     */
    private ObservationList() {
    }
    
    public ObservationList(int id, double longitude, double latitude, Precision precision, Optional<String> locationName, String listName, Optional<String> privateComment, Optional<String> publicComment, OffsetDateTime creationDateTime, Optional<OffsetDateTime> observationDateTime, Optional<Habitat> habitat, Optional<String> habitatDescription) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.precision = precision;
        this.locationName = locationName;
        this.listName = listName;
        this.privateComment = privateComment;
        this.publicComment = publicComment;
        this.creationDateTime = creationDateTime;
        this.observationDateTime = observationDateTime;
        this.habitat = habitat;
        this.habitatDescription = habitatDescription;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    private void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    private void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Precision getPrecision() {
        return precision;
    }

    private void setPrecision(Precision precision) {
        this.precision = precision;
    }

    public Optional<String> getLocationName() {
        return locationName;
    }

    private void setLocationName(Optional<String> locationName) {
        this.locationName = locationName;
    }

    public String getListName() {
        return listName;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    public Optional<String> getPrivateComment() {
        return privateComment;
    }

    private void setPrivateComment(Optional<String> privateComment) {
        this.privateComment = privateComment;
    }

    public Optional<String> getPublicComment() {
        return publicComment;
    }

    private void setPublicComment(Optional<String> publicComment) {
        this.publicComment = publicComment;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    private void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Optional<OffsetDateTime> getObservationDateTime() {
        return observationDateTime;
    }

    private void setObservationDateTime(Optional<OffsetDateTime> observationDateTime) {
        this.observationDateTime = observationDateTime;
    }

    public Optional<Habitat> getHabitat() {
        return habitat;
    }

    public void setHabitat(Optional<Habitat> habitat) {
        this.habitat = habitat;
    }

    public Optional<String> getHabitatDescription() {
        return habitatDescription;
    }

    public void setHabitatDescription(Optional<String> habitatDescription) {
        this.habitatDescription = habitatDescription;
    }
    
    
}

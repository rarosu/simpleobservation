package com.rarosu.simpleobservation.common.models;

import java.time.OffsetDateTime;
import java.util.Optional;


public class Observation {
    private int id;
    private Taxon taxon;
    private ObservationList observationList;
    private double longitude;
    private double latitude;
    private Precision precision;
    private Optional<String> locationName;
    private Optional<String> privateComment;
    private Optional<String> publicComment;
    private OffsetDateTime creationDateTime;
    private Optional<OffsetDateTime> observationDateTime;
    private Optional<Sex> sex;
    private Optional<Integer> individualCount;
    private Optional<IndividualCountMeasure> individualCountMeasure;
    private Optional<AgeStage> ageStage;
    private boolean found;
    private Optional<Habitat> habitat;
    private String habitatDescription;
    private Taxon hostTaxon;

    /**
     * Used by Hibernate.
     */
    private Observation() {
    }
    
    public Observation(int id, Taxon taxon, ObservationList observationList, double longitude, double latitude, Precision precision, Optional<String> locationName, Optional<String> privateComment, Optional<String> publicComment, OffsetDateTime creationDateTime, Optional<OffsetDateTime> observationDateTime, Optional<Sex> sex, Optional<Integer> individualCount, Optional<IndividualCountMeasure> individualCountMeasure, Optional<AgeStage> ageStage, boolean found, Optional<Habitat> habitat, String habitatDescription, Taxon hostTaxon) {
        this.id = id;
        this.taxon = taxon;
        this.observationList = observationList;
        this.longitude = longitude;
        this.latitude = latitude;
        this.precision = precision;
        this.locationName = locationName;
        this.privateComment = privateComment;
        this.publicComment = publicComment;
        this.creationDateTime = creationDateTime;
        this.observationDateTime = observationDateTime;
        this.sex = sex;
        this.individualCount = individualCount;
        this.individualCountMeasure = individualCountMeasure;
        this.ageStage = ageStage;
        this.found = found;
        this.habitat = habitat;
        this.habitatDescription = habitatDescription;
        this.hostTaxon = hostTaxon;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    private void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public ObservationList getObservationList() {
        return observationList;
    }

    private void setObservationList(ObservationList observationList) {
        this.observationList = observationList;
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

    public Optional<Sex> getSex() {
        return sex;
    }

    private void setSex(Optional<Sex> sex) {
        this.sex = sex;
    }

    public Optional<Integer> getIndividualCount() {
        return individualCount;
    }

    private void setIndividualCount(Optional<Integer> individualCount) {
        this.individualCount = individualCount;
    }

    public Optional<IndividualCountMeasure> getIndividualCountMeasure() {
        return individualCountMeasure;
    }

    private void setIndividualCountMeasure(Optional<IndividualCountMeasure> individualCountMeasure) {
        this.individualCountMeasure = individualCountMeasure;
    }

    public Optional<AgeStage> getAgeStage() {
        return ageStage;
    }

    private void setAgeStage(Optional<AgeStage> ageStage) {
        this.ageStage = ageStage;
    }

    public boolean getFound() {
        return found;
    }

    private void setFound(boolean found) {
        this.found = found;
    }

    public Optional<Habitat> getHabitat() {
        return habitat;
    }

    private void setHabitat(Optional<Habitat> habitat) {
        this.habitat = habitat;
    }

    public String getHabitatDescription() {
        return habitatDescription;
    }

    private void setHabitatDescription(String habitatDescription) {
        this.habitatDescription = habitatDescription;
    }

    public Taxon getHostTaxon() {
        return hostTaxon;
    }

    private void setHostTaxon(Taxon hostTaxon) {
        this.hostTaxon = hostTaxon;
    }
    
    
}

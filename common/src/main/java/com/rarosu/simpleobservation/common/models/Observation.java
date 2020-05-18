package com.rarosu.simpleobservation.common.models;

import java.time.OffsetDateTime;
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
@Table(name = "observation")
public class Observation {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "taxon_id")
    private Taxon taxon;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "observation_list_id")
    private ObservationList observationList;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "coordinate_precision")
    @Enumerated
    private Precision coordinatePrecision;
    
    @Column(name = "location_name")
    private String locationName;
    
    @Column(name = "private_comment")
    private String privateComment;
    
    @Column(name = "public_comment")
    private String publicComment;
    
    @Column(name = "creation_date_time")
    private OffsetDateTime creationDateTime;
    
    @Column(name = "observation_date_time")
    private OffsetDateTime observationDateTime;
    
    @Column(name = "sex")
    @Enumerated
    private Sex sex;
    
    @Column(name = "individual_count")
    private Integer individualCount;
    
    @Column(name = "individual_count_measure")
    @Enumerated
    private IndividualCountMeasure individualCountMeasure;
    
    @Column(name = "age_stage")
    @Enumerated
    private AgeStage ageStage;
    
    @Column(name = "is_found")
    private Boolean isFound;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;
    
    @Column(name = "habitat_description")
    private String habitatDescription;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "host_taxon_id")
    private Taxon hostTaxon;

    /**
     * Used by Hibernate.
     */
    Observation() {
    }
    
    public Observation(Integer id, Taxon taxon, ObservationList observationList) {
        this.id = id;
        this.taxon = taxon;
        this.observationList = observationList;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public ObservationList getObservationList() {
        return observationList;
    }

    public void setObservationList(ObservationList observationList) {
        this.observationList = observationList;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Precision getCoordinatePrecision() {
        return coordinatePrecision;
    }

    public void setCoordinatePrecision(Precision coordinatePrecision) {
        this.coordinatePrecision = coordinatePrecision;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPrivateComment() {
        return privateComment;
    }

    public void setPrivateComment(String privateComment) {
        this.privateComment = privateComment;
    }

    public String getPublicComment() {
        return publicComment;
    }

    public void setPublicComment(String publicComment) {
        this.publicComment = publicComment;
    }

    public OffsetDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(OffsetDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public OffsetDateTime getObservationDateTime() {
        return observationDateTime;
    }

    public void setObservationDateTime(OffsetDateTime observationDateTime) {
        this.observationDateTime = observationDateTime;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getIndividualCount() {
        return individualCount;
    }

    public void setIndividualCount(Integer individualCount) {
        this.individualCount = individualCount;
    }

    public IndividualCountMeasure getIndividualCountMeasure() {
        return individualCountMeasure;
    }

    public void setIndividualCountMeasure(IndividualCountMeasure individualCountMeasure) {
        this.individualCountMeasure = individualCountMeasure;
    }

    public AgeStage getAgeStage() {
        return ageStage;
    }

    public void setAgeStage(AgeStage ageStage) {
        this.ageStage = ageStage;
    }

    public Boolean getIsFound() {
        return isFound;
    }

    public void setIsFound(Boolean isFound) {
        this.isFound = isFound;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getHabitatDescription() {
        return habitatDescription;
    }

    public void setHabitatDescription(String habitatDescription) {
        this.habitatDescription = habitatDescription;
    }

    public Taxon getHostTaxon() {
        return hostTaxon;
    }

    public void setHostTaxon(Taxon hostTaxon) {
        this.hostTaxon = hostTaxon;
    }
    
    
}

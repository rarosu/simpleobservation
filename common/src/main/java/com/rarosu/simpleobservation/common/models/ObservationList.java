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
@Table(name = "observation_list")
public class ObservationList {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "coordinate_precision")
    @Enumerated
    private Precision coordinatePrecision;
    
    @Column(name = "location_name")
    private String locationName;
    
    @Column(name = "list_name")
    private String listName;
    
    @Column(name = "private_comment")
    private String privateComment;
    
    @Column(name = "public_comment")
    private String publicComment;
    
    @Column(name = "creation_date_time")
    private OffsetDateTime creationDateTime;
    
    @Column(name = "observation_date_time")
    private OffsetDateTime observationDateTime;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;
    
    @Column(name = "habitat_description")
    private String habitatDescription;

    /**
     * Used by Hibernate.
     */
    ObservationList() {
    }
    
    public ObservationList(Integer id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
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
}

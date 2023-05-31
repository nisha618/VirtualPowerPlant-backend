package com.nisha.VPP.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "battery")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatteriesModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private int id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "postcode")
    private int postcode;

    @Column(name = "capacity")
    private double capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getPostcode() {
        return postcode;
    }
    
}

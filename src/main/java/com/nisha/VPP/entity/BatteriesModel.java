package com.nisha.VPP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "battery")
public class BatteriesModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private int id;
    
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCapacity() {
        return capacity;
    }

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "capacity")
    private String capacity;
    
}

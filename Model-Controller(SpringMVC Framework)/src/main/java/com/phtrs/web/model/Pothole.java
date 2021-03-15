package com.phtrs.web.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pothole", schema = "phtrs")
@Getter
@Setter
public class Pothole {
    @Id
    @Column(name = "id", length = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "size")
    private int size;

    @Basic
    @Column(name = "location")
    private String location;

    @Basic
    @Column(name = "district")
    private String district;

    @Basic
    @Column(name = "priority")
    private String priority;

    @Basic
    @Column(name = "holestatus")
    private String holestatus;

    public String getHolestatus() {
        return holestatus;
    }

    public void setHolestatus(String holestatus) {
        this.holestatus = holestatus;
    }
}

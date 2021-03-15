package com.phtrs.web.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workorder", schema = "phtrs")
@Getter
@Setter
public class WorkOrder {
    @Id
    @Column(name = "id", length = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "crewid")
    private String crewid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrewid() {
        return crewid;
    }

    public void setCrewid(String crewid) {
        this.crewid = crewid;
    }


    public int getTeamperson() {
        return teamperson;
    }

    public void setTeamperson(int teamperson) {
        this.teamperson = teamperson;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "material")
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "cost")
    private int cost;

    @Basic
    @Column(name = "teamperson")
    private int teamperson;

    @Basic
    @Column(name = "equipment")
    private String equipment;

    @Basic
    @Column(name = "hours")
    private int hours;

    public String getHolestatus() {
        return holestatus;
    }

    public void setHolestatus(String holestatus) {
        this.holestatus = holestatus;
    }

    @Basic
    @Column(name = "holestatus")
    private String holestatus;

}

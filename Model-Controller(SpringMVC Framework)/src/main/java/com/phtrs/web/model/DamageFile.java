package com.phtrs.web.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "damagefile", schema = "phtrs")
@Getter
@Setter
public class DamageFile {
    @Id
    @Column(name = "id", length = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "potholeid")
    private int potholedid;

    @Basic
    @Column(name = "userid")
    private int userid;

    @Basic
    @Column(name = "typeofdamage")
    private String typeofdamage;

    @Basic
    @Column(name = "amount")
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPotholedid() {
        return potholedid;
    }

    public void setPotholedid(int potholedid) {
        this.potholedid = potholedid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTypeofdamage() {
        return typeofdamage;
    }

    public void setTypeofdamage(String typeofdamage) {
        this.typeofdamage = typeofdamage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package com.phtrs.web.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DamageFileDAQ extends JpaRepository <DamageFile, Integer> {
    @Query("select d.typeofdamage, d.amount, p.address, p.district, p.location, p.size, u.userName, u.address, u.phone from DamageFile d, Pothole p, User u where d.potholedid = p.id and d.userid = u.id")
    List generateById(int id);


}

package com.phtrs.web.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PotholeDAQ extends JpaRepository<Pothole, Integer> {

    @Query("select p from Pothole p")
    List<Pothole> findAllPothole();
}

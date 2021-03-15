package com.phtrs.web.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOrderDAQ extends JpaRepository<WorkOrder, Integer>{
    WorkOrder findById(int id);
    @Query("select o from WorkOrder o")
    List<WorkOrder> findAllOrder();
}

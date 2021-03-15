package com.phtrs.web.controller;

import com.phtrs.web.model.WorkOrder;
import com.phtrs.web.model.WorkOrderDAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    @Autowired
    WorkOrderDAQ workOrderDAQ;

    @RequestMapping(value = "/uploadorder", method = RequestMethod.POST)
    public ResponseEntity<String> uploadorder(@RequestParam("crewid") String crewid, @RequestParam("equipment") String equipment, @RequestParam("holestatus")String holestatus, @RequestParam("hours") int hours, @RequestParam("number") int number, @RequestParam("material") String material, @RequestParam("cost") int cost) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setCrewid(crewid);
        workOrder.setEquipment(equipment);
        workOrder.setHolestatus(holestatus);
        workOrder.setHours(hours);
        workOrder.setTeamperson(number);
        workOrder.setCost(cost);
        workOrder.setMaterial(material);
        workOrderDAQ.save(workOrder);
        return new ResponseEntity<>("上传工单成功", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateorder", method = RequestMethod.POST)
    public ResponseEntity<String> updateorder(@RequestParam("id")int id, @RequestParam("holestatus")String holestatus){
        WorkOrder workOrder = workOrderDAQ.findById(id);
        workOrder.setHolestatus(holestatus);
        workOrderDAQ.save(workOrder);
        return new ResponseEntity<>("更新状态成功", HttpStatus.OK);
    }

    @RequestMapping(value = "/allorder", method = RequestMethod.GET)
    public List<WorkOrder> allorder(){
        return workOrderDAQ.findAllOrder();
    }


}

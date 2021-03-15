package com.phtrs.web.controller;

import com.phtrs.web.model.Pothole;
import com.phtrs.web.model.PotholeDAQ;
import com.phtrs.web.model.User;
import com.phtrs.web.model.UserDAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PotholeController {
    @Autowired
    PotholeDAQ potholeDAQ;

    @RequestMapping(value = "/uploadpothole", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("address") String address, @RequestParam("size") int size, @RequestParam("location")String location, @RequestParam("district") String district, @RequestParam("priority") String priority) {
        Pothole pothole = new Pothole();
        pothole.setAddress(address);
        pothole.setDistrict(district);
        pothole.setLocation(location);
        pothole.setSize(size);
        pothole.setPriority(priority);
        pothole.setHolestatus("unrepaired");
        potholeDAQ.save(pothole);
        return new ResponseEntity<>("上传成功", HttpStatus.OK);
    }

    @RequestMapping(value = "/allpothole", method = RequestMethod.GET)
    public ResponseEntity<List<Pothole>> allpothole(){
        return new ResponseEntity<>(potholeDAQ.findAllPothole(), HttpStatus.OK);
    }
}

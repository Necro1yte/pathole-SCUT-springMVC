package com.phtrs.web.controller;

import com.phtrs.web.model.DamageFile;
import com.phtrs.web.model.DamageFileDAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DamageFileController {
    @Autowired
    DamageFileDAQ damageFileDAQ;

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public ResponseEntity<String> uploadfile(@RequestParam("userid") int userid, @RequestParam("potholeid") int potholeid, @RequestParam("typeofdamage") String typeofdamage, @RequestParam("amount") int amount) {
        DamageFile damageFile = new DamageFile();
        damageFile.setPotholedid(potholeid);
        damageFile.setUserid(userid);
        damageFile.setAmount(amount);
        damageFile.setTypeofdamage(typeofdamage);
        damageFileDAQ.save(damageFile);
        return new ResponseEntity<>("Generating File Successfully!", HttpStatus.OK);
    }

    @RequestMapping(value = "/accessfile", method = RequestMethod.GET)
    public List accessfile(@RequestParam("fileid") int fileid){
        return damageFileDAQ.generateById(fileid);

    }
}

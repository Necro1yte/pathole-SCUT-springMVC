package com.phtrs.web.controller;

import com.phtrs.web.model.Result;
import com.phtrs.web.model.User;
import com.phtrs.web.model.UserDAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegisterController {
    @Autowired
    UserDAQ userDAQ;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phone")String phone, @RequestParam("address") String address, @RequestParam("type") String type) {
        if (userDAQ.existsByUserName(username)) {
            Result result = new Result();
            Map<String, String> map = new HashMap<>();
            map.put("info", "failed");
            return Result.bad("Duplicate account！ Please login directly", map);
        } else {
            User user = new User();
            user.setUserName(username);
            user.setType(type);
            user.setPassword(password);
            user.setAddress(address);
            user.setPhone(phone);
            userDAQ.save(user);
            Result result = new Result();
            Map<String, String> map = new HashMap<>();
            map.put("info", "success");
            return Result.ok("Register successfully! ", map);
        }
    }
}

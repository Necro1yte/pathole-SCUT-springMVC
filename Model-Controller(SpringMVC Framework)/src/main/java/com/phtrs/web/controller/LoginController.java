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
public class LoginController {
    @Autowired
    UserDAQ userDAQ;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean flag1 = userDAQ.existsByUserName(username);
        if (flag1) {
            boolean flag2 = userDAQ.existsByUserNameAndPassword(username, password);
            if (flag2) {
                Result result = new Result();
                Map<String, String> map = new HashMap<>();
                map.put("info", "success");
                return Result.ok("Login successfully！", map);
            } else {
                Result result = new Result();
                Map<String, String> map = new HashMap<>();
                map.put("info", "failed");
                return Result.bad("Wrong password！Please input again!", map);
            }
        }
        else {
            Result result=new Result();
            Map<String,String> map=new HashMap<>();
            map.put("info","failed");
            return Result.bad("No match account! Please register！", map);
        }
    }
}

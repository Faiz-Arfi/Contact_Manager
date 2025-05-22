package com.contactmanager.contactmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    
    //user dashboard
    @RequestMapping(value ="/dashboard", method = RequestMethod.GET)
    public String dashboard(){
        return "user/dashboard";
    }

    //user profile
    @RequestMapping(value ="/profile") //no need to add method = RequestMethod.GET as it is by default in GET
    public String profile(){
        return "user/profile";
    }

    //add contact

    //show contacts

    //edit contact

    //delete contact

    //search contact

}

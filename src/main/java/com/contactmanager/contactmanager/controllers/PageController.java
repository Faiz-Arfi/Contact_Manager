package com.contactmanager.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contactmanager.contactmanager.forms.UserForm;
import com.contactmanager.contactmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping("/services")
    public String services(){
        return "services";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //Processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("Registration Done");
        //fetch form data
        System.out.println(userForm);
        //validate data
        if(rBindingResult.hasErrors()){
            System.out.println("Error");
            return "register";
        }
        //store data in database
        // userService.saveUser(userForm.toUser());
        boolean isSaved = userService.saveUser(userForm.toUser());
        // show success message
        if (isSaved) {
            System.out.println("User Saved Successfully");
            // Set success message
            session.setAttribute("message", "alert-success");
        } else {
            System.out.println("Failed to save user");
            // Set error message
            session.setAttribute("message", "alert-danger");
        }
        //redirect to login page
        return "redirect:/register";
    }
}

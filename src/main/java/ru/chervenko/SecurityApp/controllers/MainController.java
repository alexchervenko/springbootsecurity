package ru.chervenko.SecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chervenko.SecurityApp.services.PersonService;

@Controller
@RequestMapping
public class MainController {
    public final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String index(){
        return "main/index";
    }


    @GetMapping("/for-admin-only")
    public String forAdmin(){

        return "main/for-admin";
    }
}

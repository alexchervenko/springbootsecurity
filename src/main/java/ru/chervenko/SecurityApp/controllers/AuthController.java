package ru.chervenko.SecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chervenko.SecurityApp.models.Person;
import ru.chervenko.SecurityApp.services.PersonService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonService personService;

    @Autowired
    public AuthController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("user") Person person) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") Person person,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        personService.createUser(person);
        System.out.println(person);
        return "redirect:auth/login";
    }
}

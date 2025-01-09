package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.User;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    

    @GetMapping("/details")

    // Funcion con Model
    public String details(Model model) {

        //Instancia de la Model User
        User user = new User("Julian","Mora");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }


    @GetMapping("/list-details")
    public String list(ModelMap  model){

        /*  List<User> users = Arrays.asList(
            new User("Julian","Mora","Felipmora42@gmail.com"), 
            new User("Daniela","Lopez"),
            new User("Juan","Perez" , "Pepe2131@htomail.com")
            ); */
        //model.addAttribute("users", users);
        model.addAttribute("title", "Listado de Usuarios");
        return "list-details";
    }
    

    @ModelAttribute("users")
    public List<User> usersModel(){


        //Otra forma de retornar la lista de usuarios
        
        /* return Arrays.asList(
            new User("Julian","Mora","Felipmora42@gmail.com"), 
            new User("Daniela","Lopez"),
            new User("Juan","Perez" , "Pepe2131@htomail.com")
        ); */

        
        List<User> users = Arrays.asList(
            new User("Julian","Mora","Felipmora42@gmail.com"), 
            new User("Daniela","Lopez"),
            new User("Juan","Perez" , "Pepe2131@htomail.com")
            );

        return users;
    }
    

    // Funcion con Map
    /*
    public String details(Map<String,Object> model) {
        model.put("title", "Hola Mundo Spirng Boot");
        model.put("name", "Julian");
        model.put("lastname", "Mora");
        return "details";
    }
    */
}

package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.User;
import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
//@Controller
@RequestMapping("/api")
public class UserRestController {
    

    @GetMapping("/details")
    public  UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("Julian", "Mora");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;
    }

    @GetMapping("/list-details")
    public List<User> list(){
        
        User user = new User("Julian", "Mora");
        User user2 = new User("Valentina", "Carrillo");
        User user3 = new User("Gloria", "Hernandez");

        //Con ArrayList
        // List<User> users = new ArrayList<>();
        //users.add(user);
        //users.add(user2);
        //users.add(user3);


        //Con Arrays.asList 
        List<User> users  = Arrays.asList(user, user2, user3);

        return users;
    }




    @GetMapping("/details-map")
    public Map<String,Object> detailsMaps() {

        User user = new User("Julian","Mora");
        Map<String,Object> json = new HashMap<>();
        json.put("title", "Hola Mundo Spring Boot");
        json.put("user", user);
        return json;
    }
    

    //Utilizar con @Controller & @ResponseBody

    /* 
        @GetMapping("/details")
        @ResponseBody
        public Map<String,Object> details() {

            Map<String,Object> json = new HashMap<>();

            json.put("title", "Hola Mundo Spirng Boot");
            json.put("name", "Julian");
            json.put("lastname", "Mora");
            return json;
        }
    */



    //Utilizar con @RequestMapping

    /*
        @RequestMapping(path="/details", method=RequestMethod.GET)
        public Map<String,Object> details() {

            Map<String,Object> json = new HashMap<>();

            json.put("title", "Hola Mundo Spirng Boot");
            json.put("name", "Julian");
            json.put("lastname", "Mora");
            return json;
        }   
    */
}

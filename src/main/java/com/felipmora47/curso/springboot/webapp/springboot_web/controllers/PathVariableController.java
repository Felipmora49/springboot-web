package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.User;
import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/path")
public class PathVariableController {

    //Inyección de Valores de application.properties con @Value
    @Value("${config.username}")
    private String username;
    @Value("${config.password}")
    private String password;
    @Value("${config.listOfValues}")
    private String[]  listOfValues;
   /*  @Value("${config.code}")
    private Integer  code; */


    @GetMapping("/path-variable/{message}")
    public ParamDto variable(@PathVariable String message){

        ParamDto param =  new ParamDto();
        param.setMessage(message);
        return param;
    }
    


    @GetMapping("/mix-variables/{id}/{product}/{price}")
    public Map<String, Object> mixPathVar(@PathVariable Integer id, @PathVariable String product, @PathVariable Long price){

        Map<String,Object> json = new HashMap<>();
        json.put("id", id);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
    


    @PostMapping("/create")
    public User create(@RequestBody User user){

        //Hacer algo con el usuario recibido en la BD
        user.setName(user.getName().toUpperCase());
        return user;
    }
    


    @GetMapping("/values-config")
    public Map<String,Object> values(@Value("${config.code}") Integer code){
        Map<String, Object> json = new HashMap<>();

        json.put("username", username);
        json.put("password", password);
        json.put("listOfValues", listOfValues);
        json.put("code", code);
        return json;

    }
    
}

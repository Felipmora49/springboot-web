package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.User;
import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

/*  @Value("${config.listOfValues}")
    private List<String>  listOfValues;
 */

    /* @Value("${config.listOfValues}")
    private String[]  listOfValues; */

    /*  @Value("${config.code}")
    private Integer  code; */

    // Convertir el valor de la lista en un Array de forma manual atravez de fomar de Spring Expression Language
    @Value("#{ '${config.listOfValues}'.split(',') }")
    private List<String>  listOfValues;

      // Convertir el valor String de forma manual atravez de fomar de Spring Expression Language
    @Value("#{ '${config.listOfValues}'.toUpperCase() }")
    private String  StringlistOfValues;

    //Traer un Map de valores completo de application.properties
    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap ;


    //Traer un valor especifico de un Map de valores de application.properties
    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;



    @Autowired
    private Environment env;


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
        json.put("StringlistOfValues", StringlistOfValues);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        //Uso de Environment
        json.put("code_env", Integer.parseInt(env.getProperty("config.code")));
        // Forma de definir el tipo de dato que se espera
        json.put("code_env2", env.getProperty("config.code", Long.class));
        json.put("username_env", env.getProperty("config.username"));
        return json;

    }
    
}

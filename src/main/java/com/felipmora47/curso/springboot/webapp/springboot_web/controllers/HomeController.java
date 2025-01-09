package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping({"","/", "/home"})
    public String home() {
        
        //Genera un redireccionamiento a la pagina de list-details cambia la URL
        // return "redirect:/list-details";

        //Usa un forward para redireccionar a la pagina de list-details no cambia la URL
        return "forward:/details";
    }
    
}

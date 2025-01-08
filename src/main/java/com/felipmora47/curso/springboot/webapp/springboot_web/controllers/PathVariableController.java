package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/path")
public class PathVariableController {

    @GetMapping("/path-variable/{message}")
    public ParamDto variable(@PathVariable String message){

        ParamDto param =  new ParamDto();
        param.setMessage(message);
        return param;
    }
    
}

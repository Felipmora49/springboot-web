package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {



    @GetMapping("/params-details")
    public ParamDto paramDetails(@RequestParam(required = false, defaultValue = "Hola"/* , name="mensaje" */) String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/param-bar")
    public ParamDto paramBar(@RequestParam String text, @RequestParam Integer code){

        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
    @GetMapping("/request")
    public  ParamDto request(HttpServletRequest request){
        Integer code = 0;

        try 
        {
        code = Integer.parseInt(request.getParameter("code"));
        } 
        catch (NumberFormatException e) {
        }
        ParamDto params = new ParamDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    
    
}

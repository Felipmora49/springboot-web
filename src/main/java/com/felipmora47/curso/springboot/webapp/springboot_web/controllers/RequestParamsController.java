package com.felipmora47.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.felipmora47.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

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
    public ParamMixDto paramBar(@RequestParam String text, @RequestParam Integer code){

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
    @GetMapping("/request")
    public  ParamMixDto request(HttpServletRequest request){
        Integer code = 0;

        try 
        {
        code = Integer.parseInt(request.getParameter("code"));
        } 
        catch (NumberFormatException e) {
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    
    
}

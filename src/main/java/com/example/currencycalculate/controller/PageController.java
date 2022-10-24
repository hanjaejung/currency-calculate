package com.example.currencycalculate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {
    //화면 호출해주는 api
    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("main");
    }
}

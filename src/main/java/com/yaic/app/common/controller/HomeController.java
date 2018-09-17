package com.yaic.app.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "default")
    public String defaultPage(HttpServletRequest request) {
        return "default";
    }

}

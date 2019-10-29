package com.kw.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController implements ErrorController {

    public final String ERROR_PATH="/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "error";
    }
}

package org.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HtmlController {

    @GetMapping("/html/string")
    public String getHtmlString() {
        return "string"; 
    }
}
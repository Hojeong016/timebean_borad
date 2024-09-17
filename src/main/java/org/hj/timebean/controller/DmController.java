package org.hj.timebean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DmController {
    @GetMapping("/dm")
    public String dm(){
        return "main/dm";
    }
}

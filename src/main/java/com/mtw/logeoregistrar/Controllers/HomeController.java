package com.mtw.logeoregistrar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
    @GetMapping({"","/"})
    public String home(){
        return "Index";
    }

    @PostMapping({"/contact","/contact/"})
    public String contact(){
        return "Contact";
    }
    @GetMapping("/nosotros")
    public String nosotros(){
        return "Nosotros"; 
    }
    @GetMapping("/Eventos")
    public String eventos(){
        return "Eventos"; 
    }
}

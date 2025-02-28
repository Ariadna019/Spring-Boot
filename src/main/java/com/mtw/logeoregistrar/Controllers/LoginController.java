package com.mtw.logeoregistrar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // Redirige al dashboard de administrador esto de controller mas lo de segurity  y el html se crea otra pagina web de admins
    @GetMapping("/indexadmin")
    public String adminDashboard() {
        return "indexadmin";  // Página del administrador
    }
}


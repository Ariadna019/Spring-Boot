package com.mtw.logeoregistrar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtw.logeoregistrar.DTO.ReservaDto;
import com.mtw.logeoregistrar.Services.ReservaServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping({"/"})
public class ReservaController {

    private ReservaServiceImpl rs;

    public ReservaController(ReservaServiceImpl rs) {
        super();
        this.rs = rs;
    }

    @ModelAttribute("reserva")
    public ReservaDto nReserva(){
        return new ReservaDto();
    }

    @GetMapping({"/reservaonline/","/reservaonline"})
    public String formulario() {
        return "ReservaOnline";
    }
    
    @PostMapping({"/reservaonline","/reservaonline"})
    public String nuevaReserva(@ModelAttribute("reserva") ReservaDto rd) {
        rs.guardar(rd);
        return "redirect:reservaonline?exito";
    }
    

}

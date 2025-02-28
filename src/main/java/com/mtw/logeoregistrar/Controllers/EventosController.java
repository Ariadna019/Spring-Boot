package com.mtw.logeoregistrar.Controllers;

import com.mtw.logeoregistrar.Models.EventosModel;
import com.mtw.logeoregistrar.Services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping("/eventos")
    public String formularioEventos(Model model) {
        model.addAttribute("evento", new EventosModel());
        return "Eventos"; 
    }

    @PostMapping("/eventos")
    public String registrarEvento(@ModelAttribute("evento") EventosModel evento, Model model) {
        eventosService.guardarEvento(evento);
        model.addAttribute("mensaje", "Evento registrado con éxito");
        return "redirect:/eventos"; 
    }

        @GetMapping("/listaeventos")
    public String listarEventos(Model model) {
        // Recuperar todos los eventos de la base de datos
        model.addAttribute("eventos", eventosService.obtenerTodosLosEventos());
        return "listaeventos"; // Asegúrate de que coincide con el nombre del archivo HTML
    }
    @PostMapping("/aceptarEvento/{id}")
    public String aceptarEvento(@PathVariable Long id) {
        EventosModel evento = eventosService.obtenerEventoPorId(id);
        if (evento != null) {
            evento.setEstado("Aceptado");
            eventosService.guardarEvento(evento);
        }
        return "redirect:/listaeventos";
    }
}

package com.mtw.logeoregistrar.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtw.logeoregistrar.Models.EventosModel;
import com.mtw.logeoregistrar.Repositories.EventosRepository;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    public EventosModel guardarEvento(EventosModel evento) {
        return eventosRepository.save(evento);
    }


    public List<EventosModel> obtenerTodosLosEventos() {
        return eventosRepository.findAll();
    }

    public EventosModel obtenerEventoPorId(Long id) {
        return eventosRepository.findById(id).orElse(null);
    }

    public void aceptarEvento(Long id) {
        EventosModel evento = eventosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento no encontrado: " + id));
        evento.setEstado("Aceptado"); // Suponiendo que tienes un campo "estado" en el modelo
        eventosRepository.save(evento);
    }
}

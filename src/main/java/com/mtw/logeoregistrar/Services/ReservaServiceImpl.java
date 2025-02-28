package com.mtw.logeoregistrar.Services;

import org.springframework.stereotype.Service;

import com.mtw.logeoregistrar.DTO.ReservaDto;
import com.mtw.logeoregistrar.Models.ReservaModel;
import com.mtw.logeoregistrar.Repositories.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaServi {

    private ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ReservaModel guardar(ReservaDto rd) {
        // Transformar ReservaDto a ReservaModel
        ReservaModel reserva = new ReservaModel();
        reserva.setNombre(rd.getNombre());
        reserva.setEmail(rd.getEmail());
        reserva.setTelefono(rd.getTelefono());
        reserva.setInvitados(rd.getInvitados());
        reserva.setFecha(rd.getFecha());
        reserva.setHora(rd.getHora());

        // Guardar en la base de datos
        return reservaRepository.save(reserva);
    }
}

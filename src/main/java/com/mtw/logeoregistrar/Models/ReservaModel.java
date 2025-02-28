package com.mtw.logeoregistrar.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    private String email;
    private String telefono;
    private Integer invitados;
    private String fecha;
    private String hora;

    public ReservaModel() {
    }

    public ReservaModel(Long id, String nombre, String email, String telefono, Integer invitados, String fecha,
            String hora) {
        super();
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.invitados = invitados;
        this.fecha = fecha;
        this.hora = hora;
    }

    public ReservaModel(String nombre, String email, String telefono, Integer invitados, String fecha, String hora) {
        super();
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.invitados = invitados;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getInvitados() {
        return invitados;
    }

    public void setInvitados(Integer invitados) {
        this.invitados = invitados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "ReservaModel [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
                + ", invitados=" + invitados + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

}

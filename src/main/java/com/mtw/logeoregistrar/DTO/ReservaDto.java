package com.mtw.logeoregistrar.DTO;

public class ReservaDto {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Integer invitados;
    private String fecha;
    private String hora;

    public ReservaDto(Long id, String nombre, String email, String telefono, Integer invitados, String fecha,
            String hora) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.invitados = invitados;
        this.fecha = fecha;
        this.hora = hora;
    }

    public ReservaDto(String nombre, String email, String telefono, Integer invitados, String fecha,
            String hora) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.invitados = invitados;
        this.fecha = fecha;
        this.hora = hora;
    }

    public ReservaDto() {
        // TODO Auto-generated constructor stub
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
        return "ReservaDto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
                + ", invitados=" + invitados + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

}

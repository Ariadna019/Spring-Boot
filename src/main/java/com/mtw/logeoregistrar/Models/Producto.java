package com.mtw.logeoregistrar.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id; 
import jakarta.persistence.Table;



@Entity
@Table(name = "menu") // Nombre de la tabla en la base de datos


public class Producto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String pedido;
    private String descripcion;
    private double precio;
    
// Relación con la categoría
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    // Getters y Setters
    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    
    }
    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

   




}
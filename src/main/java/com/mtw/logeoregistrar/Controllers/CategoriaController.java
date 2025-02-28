package com.mtw.logeoregistrar.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtw.logeoregistrar.Models.CategoriaModel;
import com.mtw.logeoregistrar.Services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping()
    public ArrayList<CategoriaModel> obtenerCategorias() {
        return categoriaService.obtenerCategorias();
    }

    @PostMapping()
    public CategoriaModel guardarCategoria(@RequestBody CategoriaModel categoria) {
        return this.categoriaService.guardarCategoria(categoria);
    }

    @GetMapping(path = "/{id}")
    public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id") Integer id) {
        return this.categoriaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.categoriaService.eliminarCategoria(id);
        if (ok) {
            return "Se eliminó la categoría con id " + id;
        } else {
            return "No pudo eliminar la categoría con id " + id;
        }
    }
}
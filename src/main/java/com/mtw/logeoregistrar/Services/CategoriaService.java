package com.mtw.logeoregistrar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtw.logeoregistrar.Models.CategoriaModel;
import com.mtw.logeoregistrar.Repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    // Método para obtener todas las categorías
    public ArrayList<CategoriaModel> obtenerCategorias() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    // Método para guardar una nueva categoría
    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método para obtener una categoría por ID
    public Optional<CategoriaModel> obtenerPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Método para eliminar una categoría por ID
    public boolean eliminarCategoria(Integer id) {
        try {
            categoriaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


package com.mtw.logeoregistrar.Services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtw.logeoregistrar.Models.CategoriaModel;
import com.mtw.logeoregistrar.Models.MenuModel;
import com.mtw.logeoregistrar.Repositories.CategoriaRepository;
import com.mtw.logeoregistrar.Repositories.MenuRepository;

//Aqui se crean los métodos.
//el controlador se comunica con el servicio para que este realice operaciones como obtener, guardar, actualizar o eliminar datos.

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CategoriaRepository CategoriaRepository;

    public ArrayList<MenuModel> obtenerMenus() {
        return (ArrayList<MenuModel>) menuRepository.findAll();
    }

    public MenuModel guardarMenu(MenuModel menu) {
        Optional<CategoriaModel> categoriaOpt = CategoriaRepository.findById(menu.getCategoria().getId());
        if (categoriaOpt.isPresent()) {
        menu.setCategoria(categoriaOpt.get()); // Establecer la categoría antes de guardar
        return menuRepository.save(menu);
        } else {
        throw new RuntimeException("Categoría no encontrada");
        }
    }

    public Optional<MenuModel> obtenerPorId(Integer id) {
        return menuRepository.findById(id);
    }

    public ArrayList<MenuModel> obtenerPorCategoriaId(Integer categoriaId) {
        return menuRepository.findByCategoria_Id(categoriaId);
    }

public MenuModel actualizarMenu(MenuModel menuActualizado, Integer id) {
    Optional<MenuModel> menuExistenteOpt = menuRepository.findById(id);

    if (menuExistenteOpt.isPresent()) {
        MenuModel menuExistente = menuExistenteOpt.get();

        // actualizr los campos del men existente con los valores nuevos
        menuExistente.setPedido(menuActualizado.getPedido());
        menuExistente.setDescripcion(menuActualizado.getDescripcion());
        menuExistente.setPrecio(menuActualizado.getPrecio());

        // verificar si la categoría tmbién debe actualizase
        Optional<CategoriaModel> categoriaOpt = CategoriaRepository.findById(menuActualizado.getCategoria().getId());
        if (categoriaOpt.isPresent()) {
            menuExistente.setCategoria(categoriaOpt.get());
        } else {
            throw new RuntimeException("Categoría no encontrada");
        }

        // guarda los cambios
        return menuRepository.save(menuExistente);
    } else {
        throw new RuntimeException("Menú no encontrado");
    }
}

    // elimina un menú por ID
    public boolean eliminarMenu(Integer id) {
        try {
            menuRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.mtw.logeoregistrar.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtw.logeoregistrar.Models.MenuModel;
import com.mtw.logeoregistrar.Services.MenuService;

// el controlador se encarga de manejar las solicitudes como GET, POST, PUT, DELETE

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PutMapping(path = "/{id}")
    public MenuModel actualizarMenu(@RequestBody MenuModel menu, @PathVariable("id") Integer id) {
        return this.menuService.actualizarMenu(menu, id);
    }

    @GetMapping()
    public ArrayList<MenuModel> obtenerMenus() {
        return menuService.obtenerMenus();
    }

    @PostMapping()
    public MenuModel guardarMenu(@RequestBody MenuModel menu) {
        return this.menuService.guardarMenu(menu);
    }

    @GetMapping(path = "/{id}")
    public Optional<MenuModel> obtenerMenuPorId(@PathVariable("id") Integer id) {
        return this.menuService.obtenerPorId(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ArrayList<MenuModel> obtenerMenusPorCategoria(@PathVariable("categoriaId") Integer categoriaId) {
        return menuService.obtenerPorCategoriaId(categoriaId);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.menuService.eliminarMenu(id);
        if (ok) {
            return "Se eliminó el menú con id " + id;
        } else {
            return "No pudo eliminar el menú con id " + id;
        }
    }
}
package com.mtw.logeoregistrar.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtw.logeoregistrar.Models.MenuModel;


//puente entre el servicio y la base de datos.
@Repository
public interface MenuRepository extends CrudRepository<MenuModel, Integer> {
    public abstract ArrayList<MenuModel> findByCategoria_Id(Integer categoriaId);
}
package com.mtw.logeoregistrar.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtw.logeoregistrar.Models.MenuModel;
import com.mtw.logeoregistrar.Repositories.PideOnlineRepository;



@Controller
@RequestMapping("/")
public class PideOnlineController {

    @Autowired
    private PideOnlineRepository repo;


    @GetMapping({"/PideOnline","/PideOnline/"})    
    public String mostrarlista(Model model) {
        List<MenuModel> productos = repo.findAll(Sort.by
        (Sort.Direction.DESC, "categoria.nombre")
        .and(Sort.by(Sort.Direction.ASC, "precio")));
    model.addAttribute("productos", productos);
    return "/PideOnline";
    }
}

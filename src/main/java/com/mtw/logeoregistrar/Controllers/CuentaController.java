package com.mtw.logeoregistrar.Controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mtw.logeoregistrar.DTO.RegistroDTO;
import com.mtw.logeoregistrar.Models.ReservaModel;
import com.mtw.logeoregistrar.Models.Usuario;
import com.mtw.logeoregistrar.Repositories.ReservaRepository;
import com.mtw.logeoregistrar.Repositories.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
public class CuentaController {
    
    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private ReservaRepository reserv;


    @GetMapping("/listaclientes")
    public String listaClientes(Model model) {
        List<Usuario> clientes = repo.findByRol("CLIENTE");
        model.addAttribute("clientes", clientes);
        return "listaclientes";
    }

    @GetMapping("/listareservas")
    public String listaReserva(Model model) {
        List<ReservaModel> reserva = reserv.findAll();
        model.addAttribute("reserva", reserva);
        return "listareservas";
    }


	@GetMapping("/perfil")
	public String profile(Authentication auth, Model model) {
		Usuario user = repo.findByEmail(auth.getName());
		model.addAttribute("usuario", user);
		
		return "perfil";
	}
	
	

    

    @GetMapping("/registrate")
    public String registro(Model model){
        RegistroDTO registroDTO =  new RegistroDTO();
        model.addAttribute(registroDTO);
        model.addAttribute("success",false);
        return "Registrar";
    }

    @PostMapping("/registrate")
    public String registro(Model model, @Valid @ModelAttribute RegistroDTO registroDTO, BindingResult result){
        
        if (!registroDTO.getPassword().equals(registroDTO.getConfirmpassword())) {
            result.addError(
                new FieldError("registroDTO", "confirmpassword", "Repetir Contraseña y la Contraseña no coinciden")
            );
        }

        Usuario usuario = repo.findByEmail(registroDTO.getEmail());
        if (usuario != null) {
            result.addError(
                new FieldError("registroDTO","email","El Email ya esta siendo usado"));
        }

        if (result.hasErrors()) {
            return "Registrar";
        }

        try {
            // Determinar el rol basado en el correo
        String rol = registroDTO.getEmail().contains("@abrazoCulinario") ? "ADMIN" : "CLIENTE";
            
            var bCryptEncoder= new BCryptPasswordEncoder();
            Usuario nuevousuario = new Usuario();
            nuevousuario.setNombrec(registroDTO.getNombrec());
            nuevousuario.setEmail(registroDTO.getEmail());
            nuevousuario.setPhone(registroDTO.getPhone());
            nuevousuario.setDireccion(registroDTO.getDireccion());
            nuevousuario.setRol(rol); // Asignar el rol dinámico
            nuevousuario.setPassword(bCryptEncoder.encode(registroDTO.getPassword()));
            nuevousuario.setCreatedAt(new Date());

            // Guardar el usuario en la base de datos
        repo.save(nuevousuario);

            repo.save(nuevousuario);
            
            model.addAttribute("registroDTO", new RegistroDTO());
            model.addAttribute("success",true);

        } catch (Exception ex) {
            result.addError(
                new FieldError("registroDTO","nombrec",ex.getMessage())
            );
        }



        return "Registrar";
    }


}

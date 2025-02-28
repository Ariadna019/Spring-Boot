package com.mtw.logeoregistrar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mtw.logeoregistrar.Models.Usuario;
import com.mtw.logeoregistrar.Repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Usuario usuario =repo.findByEmail(email);
        
        if (usuario != null) {
            
            var springUser =User.withUsername(usuario.getEmail())
                            .password(usuario.getPassword())
                            .roles(usuario.getRol())
                            .build();
            return springUser;
        }

        return null;
    }
    
}

package com.mtw.logeoregistrar.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mtw.logeoregistrar.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
        @Query("SELECT u FROM Usuario u WHERE u.rol = 'cliente'")
    List<Usuario> findByRol(@Param("rol") String rol);

    public Usuario findByEmail(String email);

}

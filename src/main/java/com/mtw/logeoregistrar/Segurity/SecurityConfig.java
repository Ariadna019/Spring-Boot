package com.mtw.logeoregistrar.Segurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas
                        .requestMatchers("/", "/registrate", "/login", "/contact", "/nosotros", "/css/**", "/js/**",
                                "/img/**")
                        .permitAll()

                        // Rutas específicas para clientes
                        .requestMatchers("/PideOnline", "/ReservaOnline", "/eventos", "/Cart").hasRole("cliente")
                        .requestMatchers("/cliente/**").hasRole("cliente")

                        // Rutas específicas para administradores
                        .requestMatchers("/agregarProducto", "/guardarProducto", "/listaclientes","/vistaPide","/listaeventos").hasRole("ADMIN")

                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Cualquier otra ruta necesita autenticación
                        .anyRequest().authenticated())
                        
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler((request, response, authentication) -> {
                            boolean isAdmin = authentication.getAuthorities()
                                    .stream()
                                    .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

                            if (isAdmin) {
                                response.sendRedirect("/indexadmin"); // Redirige al dashboard de administrador
                            } else {
                                response.sendRedirect("/"); // Redirige a la página principal para otros roles
                            }
                        })
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

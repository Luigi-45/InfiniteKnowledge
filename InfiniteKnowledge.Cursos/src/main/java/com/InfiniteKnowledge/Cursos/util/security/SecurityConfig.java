package com.InfiniteKnowledge.Cursos.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests()
                .requestMatchers("/api/curso/**").hasAnyRole("DOCENTE","SECRETARIO")
                .requestMatchers("/api/docenteCurso/**").hasAnyRole("DOCENTE","SECRETARIO")
                .requestMatchers("/api/gradoSeccion/**").hasAnyRole("ESTUDIANTE","SECRETARIO")
                .requestMatchers("/api/docenteCursoForAll/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic(Customizer.withDefaults())
            .logout()
                .permitAll();
        
        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

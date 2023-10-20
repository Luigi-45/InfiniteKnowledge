package com.InfiniteKnowledge.RegistrosReportes.util.security;

import com.InfiniteKnowledge.RegistrosReportes.entities.Usuario;
import com.InfiniteKnowledge.RegistrosReportes.repositories.feignclients.IUsuarioFeignClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final IUsuarioFeignClient usuarioFeignClient;

    public UserDetailsServiceImpl(IUsuarioFeignClient usuarioFeignClient) {
        this.usuarioFeignClient = usuarioFeignClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioFeignClient.findByCorreoElectronico(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        
        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreoElectronico(),
                usuario.getContrasenia(),
                getAuthorities(usuario.getRol())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(int role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        switch (role) {
            case 0:
                authorities.add(new SimpleGrantedAuthority("ROLE_GESTOR_TI"));
                break;
            case 1:
                authorities.add(new SimpleGrantedAuthority("ROLE_SECRETARIO"));
                break;
            case 2:
                authorities.add(new SimpleGrantedAuthority("ROLE_DOCENTE"));
                break;
            case 3:
                authorities.add(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"));
                break;
        }
        
        return authorities;
    }
}

package com.InfiniteKnowledge.RegistrosReportes.repositories.feignclients;

import com.InfiniteKnowledge.RegistrosReportes.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="entitiesProfiles-application-usuario2", url="http://localhost:8082", path="/api/usuarioForAll")
public interface IUsuarioFeignClient {
    
    @GetMapping("/findByCorreoElectronico")
    public Usuario findByCorreoElectronico(@RequestParam(name="correoElectronico",defaultValue="0") String correoElectronico);
    
}

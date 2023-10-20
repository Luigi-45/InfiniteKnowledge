package com.InfiniteKnowledge.Cursos.repositories.feignclients;

import com.InfiniteKnowledge.Cursos.entities.Docente;
import com.InfiniteKnowledge.Cursos.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="entitiesProfiles-application-usuario", url="http://localhost:8082", path="/api/usuarioForAll")
public interface IUsuarioFeignClient {
    
    @GetMapping("/findByCorreoElectronico")
    public Usuario findByCorreoElectronico(@RequestParam(name="correoElectronico",defaultValue="0") String correoElectronico);
    
    @GetMapping("/findDocenteById")
    public Docente findDocenteById(@RequestParam(name="docenteId",defaultValue="0") int docenteId);
}

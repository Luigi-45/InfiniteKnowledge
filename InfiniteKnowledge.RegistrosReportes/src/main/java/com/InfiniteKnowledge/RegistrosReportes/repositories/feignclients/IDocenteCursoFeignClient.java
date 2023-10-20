package com.InfiniteKnowledge.RegistrosReportes.repositories.feignclients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="entitiesProfiles-application-docenteCurso", url="http://localhost:8083", path="/api/docenteCursoForAll")
public interface IDocenteCursoFeignClient {
    
    @GetMapping("/findNames")
    public List<Object[]> findNames();
    
}

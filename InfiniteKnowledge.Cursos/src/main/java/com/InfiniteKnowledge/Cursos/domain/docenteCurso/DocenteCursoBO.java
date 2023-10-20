package com.InfiniteKnowledge.Cursos.domain.docenteCurso;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import com.InfiniteKnowledge.Cursos.entities.Docente;
import com.InfiniteKnowledge.Cursos.entities.DocenteCurso;
import com.InfiniteKnowledge.Cursos.repositories.ICursoRepository;
import com.InfiniteKnowledge.Cursos.repositories.IDocenteCursoRepository;
import com.InfiniteKnowledge.Cursos.repositories.feignclients.IUsuarioFeignClient;
import com.InfiniteKnowledge.Cursos.util.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocenteCursoBO implements IDocenteCursoBOCRUD{

    private final ICursoRepository cursoRepository;
    
    @Autowired
    private IDocenteCursoRepository docenteCursoRepository;
    
    @Autowired
    private IUsuarioFeignClient docenteFeignClient;

    public DocenteCursoBO(ICursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    @Override
    public DocenteCurso save(DocenteCurso docenteCurso) {
        return docenteCursoRepository.save(docenteCurso);
    }

    @Override
    public List<DocenteCurso> findAll() {
        return docenteCursoRepository.findAll();
    }

    @Override
    public DocenteCurso findById(int docenteCursoId) {
        return docenteCursoRepository.findById(docenteCursoId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el docente y curso asignados con el id: "+docenteCursoId));
    }

    @Override
    public void deleteById(int docenteCursoId) {
        docenteCursoRepository.deleteById(docenteCursoId);
    }

    @Override
    public DocenteCurso findByDocenteIdAndCursoId(int docenteId, int cursoId) {
        return docenteCursoRepository.findByDocenteIdAndCursoId(docenteId, cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el docente y curso asignados con el id: "+docenteId+" y el id: "+cursoId+" respectivamente"));
    }

    @Override
    public List<Object[]> findNames() {
        List<DocenteCurso> docentesCurso = this.findAll();
        
        List<Object[]> answer = new ArrayList<>();
        
        for(DocenteCurso dc:docentesCurso){
            Object[] objetos = new Object[3];
            
            objetos[0] = dc.getDocenteCursoId();
            
            Docente docente = this.docenteFeignClient.findDocenteById(dc.getDocenteId());
            objetos[1] = docente.getNombre()+" "+docente.getApellido();
            
            Curso curso = this.cursoRepository.findById(dc.getCursoId())
                   .orElseThrow(() -> new ResourceNotFoundException("No existe el curso con el id: "+dc.getCursoId()));
            objetos[2] = curso.getNombre();
            
            answer.add(objetos);
        }
        
        return answer;
    }
    
}

package com.Microservicio.GestionDeCursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservicio.GestionDeCursos.model.Curso;
import com.Microservicio.GestionDeCursos.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getCurso(){
        List<Curso> cursos = cursoService.listarTodos();
        if (cursos.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Curso> postCurso(@RequestBody Curso curso){
        Curso buscado = cursoService.findById(curso.getCursoId());
        if(buscado == null)
        {
            return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
        }
        else
        {
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }


    }
}
    

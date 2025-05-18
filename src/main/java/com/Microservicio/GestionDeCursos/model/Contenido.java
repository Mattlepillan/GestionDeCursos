package com.Microservicio.GestionDeCursos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contenido")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String ramo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "CursoId")
    @JsonBackReference
    private Curso curso;
    
}

/*
Ejemplo de json 
{
  "id": 1,
  "nombre": "Introducción a la Programación",
  "ramo": "Informática",
  "curso": {
    "cursoId": 1
  }
}
*/

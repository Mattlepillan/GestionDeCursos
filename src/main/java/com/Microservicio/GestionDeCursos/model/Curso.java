package com.Microservicio.GestionDeCursos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cursoId;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 500, nullable = false)
    private String descripcion;

    @Column(length = 250, nullable = false)
    private String estadoCurso;


}



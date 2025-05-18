package com.Microservicio.GestionDeCursos.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "inscripciones")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(referencedColumnName = "CursoId")
    @JsonBackReference
    private Curso cursos;

}

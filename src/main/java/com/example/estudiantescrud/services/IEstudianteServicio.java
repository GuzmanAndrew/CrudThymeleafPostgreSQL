package com.example.estudiantescrud.services;

import com.example.estudiantescrud.entities.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    List<Estudiante> listarEstudiante();

    Estudiante guardarEstudiante(Estudiante estudiante);

    Estudiante estudianteId(Long id);

    Estudiante actualizarEstudiante(Estudiante estudiante);

    void eliminarEstudiante(Long id);
}

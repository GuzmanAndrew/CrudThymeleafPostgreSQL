package com.example.estudiantescrud.services.impl;

import com.example.estudiantescrud.entities.Estudiante;
import com.example.estudiantescrud.repositories.EstudiantesRepository;
import com.example.estudiantescrud.services.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio {

    @Autowired
    private EstudiantesRepository estudiantesRepository;

    @Override
    public List<Estudiante> listarEstudiante() {
        return estudiantesRepository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    @Override
    public Estudiante estudianteId(Long id) {
        return estudiantesRepository.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudiantesRepository.deleteById(id);
    }
}

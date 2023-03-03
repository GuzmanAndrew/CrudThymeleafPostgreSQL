package com.example.estudiantescrud.repositories;

import com.example.estudiantescrud.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiante, Long> {
}

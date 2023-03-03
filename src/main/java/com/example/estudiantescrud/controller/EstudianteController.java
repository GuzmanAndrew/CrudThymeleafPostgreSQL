package com.example.estudiantescrud.controller;

import com.example.estudiantescrud.entities.Estudiante;
import com.example.estudiantescrud.services.impl.EstudianteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteServicioImpl estudianteServicio;

    @GetMapping({"/list", "/"})
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteServicio.listarEstudiante());
        return "index"; // nos retornar al archivo html que se llama index.html
    }

    @GetMapping("/form/crear")
    public String mostrarFormCrearEstudiantes(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/nuevo")
    public String crearEstudiantes(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/list";
    }

    @GetMapping("/form/editar/{id}")
    public String mostrarFormEditarEstudiantes(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudianteServicio.estudianteId(id));
        return "editar_estudiante";
    }

    @PostMapping("/editar/{id}")
    public String editarEstudiantes(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteServicio.estudianteId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        estudianteServicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/list";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiantes(@PathVariable Long id) {
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/list";
    }
}

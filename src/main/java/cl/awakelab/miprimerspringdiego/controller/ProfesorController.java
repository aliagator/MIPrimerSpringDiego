package cl.awakelab.miprimerspringdiego.controller;

import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }
    @GetMapping("/crearProfesor")//Llama al formulario
    public String mostrarFormularioCrearProfesor(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso(); // Obtén la lista de cursos
        model.addAttribute("listaCursos", listaCursos); // Agrega la lista de cursos al modelo
        return "templateFormularioCrearProfesor";
    }
    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }
    @PostMapping("/eliminarProfesor/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }
    @GetMapping("/editarProfesor/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Profesor profesor = objProfesorService.listarProfesorId(id);

        if (profesor == null) {
            // Manejo de error si el profesor no existe
            return "redirect:/profesor";
        }

        List<Curso> listaCursos = objCursoService.listarCurso();

        model.addAttribute("profesor", profesor);
        model.addAttribute("listaCursos", listaCursos);
        return "templateFormularioEditarProfesor";
    }
    @PostMapping("/editarProfesor/{id}")
    public String actualizarProfesor(@PathVariable int id, @ModelAttribute Profesor profesor) {
        Profesor profesorActualizado = objProfesorService.actualizarProfesor(profesor);

        if (profesorActualizado == null) {
            // Manejo de error si el profesor no existe o no se pudo actualizar
            return "redirect:/profesor";
        }

        // Redirecciona a la página de lista de profesores o a donde desees después de la edición
        return "redirect:/profesor";
    }

}

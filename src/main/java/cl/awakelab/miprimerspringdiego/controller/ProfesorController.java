package cl.awakelab.miprimerspringdiego.controller;

import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;
    @GetMapping
    public String listarProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }
    @GetMapping("/crear")//Llama al formulario
    public String mostrarFormularioCrearProfesor(){
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

        model.addAttribute("profesor", profesor);
        return "templateFormularioEditarProfesor";
    }
    @PostMapping("/editarProfesor/{id}")
    public String actualizarProfesor(@PathVariable int id, @ModelAttribute Profesor profesor) {
        // Lógica para actualizar el profesor en la base de datos
        objProfesorService.actualizarProfesor(profesor);
        // Redirecciona a la página de lista de profesores o a donde desees después de la edición
        return "redirect:/profesor";
    }
}

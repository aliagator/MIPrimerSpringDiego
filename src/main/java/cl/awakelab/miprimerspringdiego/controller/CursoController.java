package cl.awakelab.miprimerspringdiego.controller;

import cl.awakelab.miprimerspringdiego.entity.Alumno;
import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.service.IAlumnoService;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarCursos(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListaCursos", listaCursos);
        return "templateListarCursos";
    }
    @GetMapping("/crearCurso")//Llama al formulario
    public String mostrarFormularioCrearCurso(){
        return "templateFormularioCrearCurso";
    }
    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso){
        objCursoService.crearCurso(curso);
        return "redirect:/curso";
    }
    @PostMapping("/eliminarCurso/{id}")
    public String eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return "redirect:/curso";
    }
    @GetMapping("/editarCurso/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Curso curso = objCursoService.listarCursoId(id);

        if (curso == null) {
            // Manejo de error si el curso no existe
            return "redirect:/curso";
        }

        model.addAttribute("curso", curso);
        return "templateFormularioEditarCurso";
    }
    @PostMapping("/editarCurso/{id}")
    public String actualizarCurso(@PathVariable int id, @ModelAttribute Curso curso) {
        // Lógica para actualizar el curso en la base de datos
        objCursoService.actualizarCurso(curso);
        // Redirecciona a la página de lista de cursos o a donde desees después de la edición
        return "redirect:/curso";
    }
}

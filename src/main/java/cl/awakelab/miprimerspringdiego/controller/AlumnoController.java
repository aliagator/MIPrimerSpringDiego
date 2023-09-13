package cl.awakelab.miprimerspringdiego.controller;

import cl.awakelab.miprimerspringdiego.entity.Alumno;
import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.service.IAlumnoService;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarAlumnos(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumno();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }
    @GetMapping("/crearAlumno")
    public String mostrarFormularioCrearAlumno(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("listaCursos", listaCursos);
        return  "templateFormularioCrearAlumno";
    }
    @PostMapping("/crearAlumno")
    public String crearAlumno(@ModelAttribute Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";
    }
    @PostMapping("/eliminarAlumno/{id}")
    public String eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }
    @GetMapping("/editarAlumno/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Alumno alumno = objAlumnoService.listarAlumnoId(id);

        if (alumno == null) {
            // Manejo de error si el alumno no existe
            return "redirect:/alumno";
        }

        List<Curso> listaCursos = objCursoService.listarCurso();

        model.addAttribute("alumno", alumno);
        model.addAttribute("listaCursos", listaCursos);
        return "templateFormularioEditarAlumno";
    }
    @PostMapping("/editarAlumno/{id}")
    public String actualizarAlumno(@PathVariable int id, @ModelAttribute Alumno alumno) {
        // Lógica para actualizar el alumno en la base de datos
        objAlumnoService.actualizarAlumno(alumno);
        // Redirecciona a la página de lista de alumnos o a donde desees después de la edición
        return "redirect:/alumno";
    }
}

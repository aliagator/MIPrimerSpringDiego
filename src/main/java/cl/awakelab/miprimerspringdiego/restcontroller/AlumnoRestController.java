package cl.awakelab.miprimerspringdiego.restcontroller;

import cl.awakelab.miprimerspringdiego.entity.Alumno;
import cl.awakelab.miprimerspringdiego.service.IAlumnoService;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return alumno;
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno){ //PathVariable (llama una variable), RequestBody (llama un objeto)
        return objAlumnoService.actualizarAlumno(alumno);
    }

    @GetMapping
    public List<Alumno> listarAlumno(){
        return objAlumnoService.listarAlumno();
    }

    @GetMapping("/{id}")
    public Alumno listarAlumnoId(@PathVariable int id){
        return objAlumnoService.listarAlumnoId(id);
    }

    @DeleteMapping("/{id}")//DeteleMapping solicitud para eliminar elementos
    public ResponseEntity<String> eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return ResponseEntity.ok("Alumno eliminado exitosamente");
    }




}

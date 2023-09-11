package cl.awakelab.miprimerspringdiego.restcontroller;

import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor){
        return objProfesorService.crearProfesor(profesor);
    }

    @GetMapping
    public List<Profesor> listarProfesor(){
        return objProfesorService.listarProfesor();
    }

    @GetMapping("/{id}")
    public Profesor listarProfesorId(@PathVariable int id){
        return  objProfesorService.listarProfesorId(id);
    }

    @PutMapping
    public Profesor actualizarProfesor(@RequestBody Profesor profesor){
        return  objProfesorService.actualizarProfesor(profesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return ResponseEntity.ok("Profesor eliminado exitosamente");
    }
}

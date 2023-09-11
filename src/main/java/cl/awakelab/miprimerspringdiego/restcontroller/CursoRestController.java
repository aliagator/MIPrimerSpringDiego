package cl.awakelab.miprimerspringdiego.restcontroller;

import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso){

        return objCursoService.crearCurso(curso);
    }

    @GetMapping
    public List<Curso> listarCurso(){

        return  objCursoService.listarCurso();
    }

    @GetMapping("/{id}")
    public Curso listarCursoId(@PathVariable int id){

        return  objCursoService.listarCursoId(id);
    }

    @PutMapping
    public Curso actualizarCurso(@RequestBody Curso curso){

        return  objCursoService.actualizarCurso(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return ResponseEntity.ok("Curso eliminado exitosamente");
    }
}

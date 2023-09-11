package cl.awakelab.miprimerspringdiego.restcontroller;

import cl.awakelab.miprimerspringdiego.entity.Usuario;
import cl.awakelab.miprimerspringdiego.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){

        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario(){

        return objUsuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id) {

        return objUsuarioService.listarUsuarioId(id);
    }

    @PutMapping
    public  Usuario actualizarUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
}

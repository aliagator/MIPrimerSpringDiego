package cl.awakelab.miprimerspringdiego.controller;

import cl.awakelab.miprimerspringdiego.entity.Usuario;
import cl.awakelab.miprimerspringdiego.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;
    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuarios", listaUsuarios);
        return "templateListarUsuarios";
    }
    @GetMapping("/crearUsuario")//Llama al formulario
    public String mostrarFormularioCrearUsuario(){
        return "templateFormularioCrearUsuario";
    }
    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }
    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuario";
    }
    @GetMapping("/editarUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Usuario usuario = objUsuarioService.listarUsuarioId(id);

        if (usuario == null) {
            // Manejo de error si el usuario no existe
            return "redirect:/usuario";
        }

        model.addAttribute("usuario", usuario);
        return "templateFormularioEditarUsuario";
    }
    @PostMapping("/editarUsuario/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute Usuario usuario) {
        // Lógica para actualizar el usuario en la base de datos
        objUsuarioService.actualizarUsuario(usuario);
        // Redirecciona a la página de lista de usuarios o a donde desees después de la edición
        return "redirect:/usuario";
    }

}

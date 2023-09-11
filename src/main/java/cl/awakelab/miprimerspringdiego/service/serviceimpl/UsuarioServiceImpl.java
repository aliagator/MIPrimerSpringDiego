package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Usuario;
import cl.awakelab.miprimerspringdiego.repository.IUsuarioRepository;
import cl.awakelab.miprimerspringdiego.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuarioCreado) {
        return objUsuarioRepo.save(usuarioCreado); //Forma Corta de Crear
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        usuarioActualizado.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActualizado.setRol(usuario.getRol());
        usuarioActualizado.setContrasena(usuario.getContrasena());
        usuarioActualizado = objUsuarioRepo.save(usuarioActualizado);
        return usuarioActualizado;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = objUsuarioRepo.findAll();
        return listaUsuario;
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        objUsuarioRepo.deleteById(idUsuario);
    }

    @Override
    public Usuario listarUsuarioId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElse(null);
    }
}
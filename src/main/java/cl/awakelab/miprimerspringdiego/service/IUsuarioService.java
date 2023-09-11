package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuario();
    public Usuario crearUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(int idUsuario);

}

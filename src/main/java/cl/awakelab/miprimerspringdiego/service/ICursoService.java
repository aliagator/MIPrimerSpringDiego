package cl.awakelab.miprimerspringdiego.service;

import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.entity.Usuario;

import java.util.List;

public interface ICursoService {
    public List<Curso> listarCurso();
    public Curso crearCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);
    public void eliminarCurso(int idCurso);
    public Curso listarCursoId(int idCurso);
}

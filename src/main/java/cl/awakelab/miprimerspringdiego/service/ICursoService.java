package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> listarCurso();
    public Curso crearCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);
    public void eliminarCurso(int idCurso);
}

package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Alumno;

import java.util.List;

public interface IAlumnoService {
    public List<Alumno> listarAlumno();
    public Alumno crearAlumno(Alumno alumno);
    public Alumno actualizarAlumno(Alumno alumno);
    public void eliminarAlumno(int idAlumno);

}

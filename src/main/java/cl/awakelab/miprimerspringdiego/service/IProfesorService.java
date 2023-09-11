package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    public List<Profesor> listarProfesor();
    public Profesor crearProfesor(Profesor profesor);
    public Profesor actualizarProfesor(Profesor profesor);
    public void eliminarProfesor(int idProfesor);
}

package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Alumno;
import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.repository.ICursoRepository;
import cl.awakelab.miprimerspringdiego.repository.IProfesorRepository;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    IProfesorRepository objProfesorRepo;
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaProfesor = new ArrayList<>();
        listaProfesor = objProfesorRepo.findAll();
        return listaProfesor;
    }

    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        // Obtiene la lista de cursos seleccionados en el formulario.
        List<Curso> cursosSeleccionados = profesorCreado.getListaCursos();

        // Para cada curso seleccionado, asocia el profesor con ese curso.
        for (Curso curso : cursosSeleccionados) {
            curso.getListaProfesores().add(profesorCreado);
        }

        // Guarda el profesor en la base de datos.
        Profesor nuevoProfesor = objProfesorRepo.save(profesorCreado);

        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        Profesor profesorActualizado = objProfesorRepo.findById(profesor.getId()).orElse(null);

        if (profesorActualizado != null) {
            // Actualizar los campos del profesor
            profesorActualizado.setNombres(profesor.getNombres());
            profesorActualizado.setApellido1(profesor.getApellido1());
            profesorActualizado.setApellido2(profesor.getApellido2());
            // Actualizar la lista de cursos asignados (asumiendo que listaCursos es una lista de IDs)
            profesorActualizado.setListaCursos(profesor.getListaCursos());

            // Guardar el profesor actualizado en la base de datos
            profesorActualizado = objProfesorRepo.save(profesorActualizado);
        }

        return profesorActualizado;
    }
    @Override
    public void eliminarProfesor(int idProfesor) {
        objProfesorRepo.deleteById(idProfesor);
    }

    @Override
    public Profesor listarProfesorId(int idProfesor) {
        return objProfesorRepo.findById(idProfesor).orElse(null);
    }
}

package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Profesor;
import cl.awakelab.miprimerspringdiego.repository.IProfesorRepository;
import cl.awakelab.miprimerspringdiego.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    IProfesorRepository objProfesorRepo;
    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaProfesor = new ArrayList<>();
        listaProfesor = objProfesorRepo.findAll();
        return listaProfesor;
    }

    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        return objProfesorRepo.save(profesorCreado);
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        Profesor profesorActualizado = new Profesor();
        profesorActualizado = objProfesorRepo.findById(profesor.getId()).orElse(null);
        profesorActualizado.setNombres(profesor.getNombres());
        profesorActualizado.setApellido1(profesor.getApellido1());
        profesorActualizado.setApellido2(profesor.getApellido2());
        profesorActualizado.setListaCursos(profesor.getListaCursos());
        profesorActualizado = objProfesorRepo.save(profesorActualizado);
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

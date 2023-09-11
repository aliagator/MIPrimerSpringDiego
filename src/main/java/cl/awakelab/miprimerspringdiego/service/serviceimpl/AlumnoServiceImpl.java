package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Alumno;
import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.repository.IAlumnoRepository;
import cl.awakelab.miprimerspringdiego.repository.ICursoRepository;
import cl.awakelab.miprimerspringdiego.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public List<Alumno> listarAlumno() {
        List<Alumno> listaAlumno = new ArrayList<>();
        listaAlumno = objAlumnoRepo.findAll();
        return listaAlumno;
    }
    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) {
        Alumno nuevoAlumno = new Alumno();
        Curso cursoAsignado = new Curso();
        cursoAsignado = objCursoRepo.findById(alumnoCreado.getCursoAsignado().getId()).orElse(null);
        alumnoCreado.setCursoAsignado(cursoAsignado);
        nuevoAlumno = objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno; //Manera larga de crear
    }
    @Override
    public Alumno actualizarAlumno(Alumno alumno) {
        Alumno alumnoActualizado = new Alumno();
        alumnoActualizado = objAlumnoRepo.findById(alumno.getId()).orElse(null);
        alumnoActualizado.setNombres(alumno.getNombres());
        alumnoActualizado.setApellido1(alumno.getApellido1());
        alumnoActualizado.setApellido2(alumno.getApellido2());
        alumnoActualizado.setCursoAsignado(alumno.getCursoAsignado());
        alumnoActualizado = objAlumnoRepo.save(alumnoActualizado);
        return alumnoActualizado;
    }
    @Override
    public void eliminarAlumno(int idAlumno) {
        objAlumnoRepo.deleteById(idAlumno);
    }
    @Override
    public Alumno listarAlumnoId(int idAlumno) {
        return objAlumnoRepo.findById(idAlumno).orElse(null);
    }
}

package cl.awakelab.miprimerspringdiego.service.serviceimpl;

import cl.awakelab.miprimerspringdiego.entity.Curso;
import cl.awakelab.miprimerspringdiego.repository.ICursoRepository;
import cl.awakelab.miprimerspringdiego.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public List<Curso> listarCurso() {
        List<Curso> listaCurso = new ArrayList<>();
        listaCurso = objCursoRepo.findAll();
        return listaCurso;
    }
    @Override
    public Curso crearCurso(Curso cursoCreado) {
        return objCursoRepo.save(cursoCreado);
    }
    @Override
    public Curso actualizarCurso(Curso curso) {
        Curso cursoActualizado = new Curso();
        cursoActualizado = objCursoRepo.findById(curso.getId()).orElse(null);
        cursoActualizado.setNombreCurso(curso.getNombreCurso());
        cursoActualizado.setListaAlumnos(curso.getListaAlumnos());
        cursoActualizado.setListaProfesores(curso.getListaProfesores());
        cursoActualizado = objCursoRepo.save(cursoActualizado);
        return cursoActualizado;
    }

    @Override
    public void eliminarCurso(int idCurso) {
        objCursoRepo.deleteById(idCurso);
    }

    @Override
    public Curso listarCursoId(int idCurso) {
        return objCursoRepo.findById(idCurso).orElse(null);
    }
}

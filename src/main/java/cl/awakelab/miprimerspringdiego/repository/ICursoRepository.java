package cl.awakelab.miprimerspringdiego.repository;

import cl.awakelab.miprimerspringdiego.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}

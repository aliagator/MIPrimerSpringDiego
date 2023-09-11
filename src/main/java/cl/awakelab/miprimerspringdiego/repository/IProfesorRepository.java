package cl.awakelab.miprimerspringdiego.repository;

import cl.awakelab.miprimerspringdiego.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {
}

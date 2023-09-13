package cl.awakelab.miprimerspringdiego.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 5)
    private String nombreCurso;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaCursos", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Profesor> listaProfesores;

    @JsonIgnore
    @OneToMany(mappedBy = "cursoAsignado", cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Alumno> listaAlumnos;


}

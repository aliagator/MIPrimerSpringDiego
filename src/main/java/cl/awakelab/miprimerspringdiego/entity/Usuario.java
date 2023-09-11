package cl.awakelab.miprimerspringdiego.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private int id;

    @Column(nullable = false,length = 50)
    private String nombreUsuario;

    @Column(length = 30)
    private String contrasena;

    @Column(length = 30)
    private String rol;
}

package ecommerce.api.home.living.senai.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


}

package ecommerce.api.home.living.senai.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario_client")
@Getter
public class UsuarioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "senha", nullable = false, length = 8, unique = true)
    private String senha;
    private boolean ativo = true;

    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    public List<Pedido> pedidos;

    public UsuarioCliente(String nome, String email){
        this.nome =
                Objects.requireNonNull
                        (nome, "O nome não pode ser nulo");
        this.email =
                Objects.requireNonNull
                        (email, "O email é obrigatorio");
    }

    public UsuarioCliente(){

    }

    public void desativarUser() {
        this.ativo = false;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof UsuarioCliente user)) return false;
        return id != null && id.equals(user.getId());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}

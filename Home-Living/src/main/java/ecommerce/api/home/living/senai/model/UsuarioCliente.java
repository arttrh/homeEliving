package ecommerce.api.home.living.senai.model;

import ecommerce.api.home.living.senai.service.validation.NameValidated;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
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
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
    private boolean ativo = true;

    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    public List<Pedido> pedidos;

    protected UsuarioCliente(String nome, String email, String senha){
        this.nome =
                Objects.requireNonNull
                        (nome, "O nome não pode ser nulo");
        this.email =
                Objects.requireNonNull
                        (email, "O email é obrigatorio");
        this.senha = Objects.requireNonNull(senha, "Senha é invalida");
    }

    public UsuarioCliente(){

    }
    public static Result<UsuarioCliente, List<String>> created(String nome, String email, String senhaHash, PasswordEncoder encoder){
        final int EMAIL_CHARACTER_MIN = 10;
        List<String> erros = new ArrayList<>();
        if (nome == null || nome.trim().length() < 2){
            erros.add("O nome é muito curto");
        }
        if (email == null || email.trim().length() < EMAIL_CHARACTER_MIN || !email.contains("@") || email.isBlank()){
            erros.add("Email invalido");
        }
        if (senhaHash.trim().length() < 60 || senhaHash.isBlank()){
            erros.add("Senha é invalida para criptografar");
        }
        if (!erros.isEmpty()){
            return Result.fail(erros);
        }

        return Result.ok(new UsuarioCliente(nome.trim(), email, encoder.encode(senhaHash)));
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

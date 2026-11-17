package ecommerce.api.home.living.senai.service;

import ecommerce.api.home.living.senai.ValidacaoException;
import ecommerce.api.home.living.senai.model.Result;
import ecommerce.api.home.living.senai.model.UsuarioCliente;
import ecommerce.api.home.living.senai.repository.UsuarioClienRepository;
import ecommerce.api.home.living.senai.service.validation.NameValidated;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class UsuarioClientService {
    private final NameValidated nameValidated;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioClienRepository repository;

    public UsuarioClientService(NameValidated nameValidated, PasswordEncoder passwordEncoder, UsuarioClienRepository repository){
        this.nameValidated = nameValidated;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Transactional
    public UsuarioCliente cadastrar(String nome, String email, String senha){
        Result<UsuarioCliente, List<String>> resultadoOperationCreated =
                UsuarioCliente.created(nome, email, senha, passwordEncoder);
            if (!resultadoOperationCreated.isOk()){
                throw new ValidacaoException(resultadoOperationCreated.errors());
        }
            return repository.save(resultadoOperationCreated.value());
    }
}

package ecommerce.api.home.living.senai.repository;

import ecommerce.api.home.living.senai.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienRepository extends JpaRepository<UsuarioCliente, Long> {

}

package ecommerce.api.home.living.senai.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "produto")
@Getter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;
    @Column(name = "valor_produto", nullable = false)
    private double valorProduto;
    @Column(name = "tipo_produto", nullable = false, length = 100)
    private String tipoProduto;
    private LocalDateTime garantia;
}

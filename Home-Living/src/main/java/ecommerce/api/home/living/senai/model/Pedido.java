package ecommerce.api.home.living.senai.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioCliente idUsuario;
    @Column(name = "data_compra", nullable = false)
    private LocalDateTime dataCompra = LocalDateTime.now();
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    public Pedido(BigDecimal valorTotal){
        if (valorTotal == null || valorTotal.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Valor é nulo");
        }
        this.valorTotal = valorTotal;
    }
}

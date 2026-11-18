package ecommerce.api.home.living.senai.model;

import jakarta.persistence.*;

@Entity
@Table
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @JoinColumn(name = "id_pedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Long idPedido;
    @JoinColumn(name = "id_produto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Long idProduto;
    @Column(name = "quantidade" , nullable = false)
    private int quantidade;
    @Column(name = "preco_unitario" , nullable = false )
    private double precoUnitario;
    public ItensPedido(int quantidade, double precoUnitario){
        if(quantidade <= 0 ){
            throw new RuntimeException("Valor Invalido!");
        }
        this.quantidade =  quantidade;
        if(precoUnitario <= 0){
            throw  new RuntimeException("Valor Invalido!");
        }

        this.precoUnitario = precoUnitario;

    }





}

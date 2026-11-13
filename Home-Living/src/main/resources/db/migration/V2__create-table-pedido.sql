CREATE TABLE pedido(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_usuario BIGINT NOT NULL,
    data_compra TIMESTAMP NOT NULL,
    valor_total DECIMAL(19, 2) NOT NULL,
    FOREIGN KEY (id_usuario)
                   REFERENCES usuario_client(id)
);
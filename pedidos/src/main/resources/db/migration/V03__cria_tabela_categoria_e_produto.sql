CREATE TABLE categoria_produto(
    id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    produto_id BIGINT(20) NOT NULL,
    categoria_id BIGINT(20) NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto (id),
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria_produto (produto_id, categoria_id) VALUES
(1, 1),
(2, 3),
(3, 2);
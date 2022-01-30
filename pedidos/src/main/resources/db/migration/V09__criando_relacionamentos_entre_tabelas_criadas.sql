ALTER TABLE pedido ADD COLUMN(
  cliente_id BIGINT(20) NOT NULL,
  endereco_de_entrega_id BIGINT(20) NOT NULL,
  pagamento_id BIGINT(20) NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES cliente (id),
  FOREIGN KEY (endereco_de_entrega_id) REFERENCES endereco (id),
  FOREIGN KEY (pagamento_id) REFERENCES pagamento (id)
);

ALTER TABLE item_pedido ADD COLUMN(
    pedido_id BIGINT(20) NOT NULL,
    produto_id BIGINT(20) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido (id),
    FOREIGN KEY (produto_id) REFERENCES produto (id)
);

ALTER TABLE endereco ADD COLUMN(
    cliente_id BIGINT(20) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

INSERT INTO endereco(logradouro, numero, complemento, bairro, cep, cidade, estado, cliente_id) VALUES
    ("Avenida Mato Grosso", "562", "Em Frente a um Prédio", "Turu", "65066-487", "São Luís", "MA", 1),
    ("Vila da Folha", "562", "Em Frente a casa do Hokage", "País do Fogo", "65000-487", "São Luís", "MA", 1);
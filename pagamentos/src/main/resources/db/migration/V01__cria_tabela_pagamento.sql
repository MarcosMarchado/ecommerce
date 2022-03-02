CREATE TABLE pagamento(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_do_pagamento VARCHAR(255) NOT NULL,
    id_usuario BIGINT(20) NOT NULL
);

CREATE TABLE pagamento_cartao(
    id BIGINT(20) NOT NULL,
    numero_de_parcelas SMALLINT NOT NULL,
    FOREIGN KEY (id) REFERENCES pagamento (id)
);

CREATE TABLE pagamento_boleto(
    id BIGINT(20) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATETIME,
    FOREIGN KEY (id) REFERENCES pagamento (id)
);

CREATE TABLE cliente (

    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    cpf VARCHAR(12) NOT NULL,
    senha VARCHAR(200) NOT NULL,
    telefone VARCHAR(12) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cliente (nome, email, cpf, senha, telefone) VALUES
    ("Monkey D. Luffy", "monkeyd_luffy@onepiece.com.br", "00045678910", "senha123", "98987868457");
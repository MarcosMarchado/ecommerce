CREATE TABLE produto(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (nome, preco) VALUES
("PC Gamer NTC VULCANO II Powered By Asus Intel Core i5-10400, 16GB RAM, SSD 480GB", 4150.9),
("Cama Box Conjugada Casal Ortopédico 55x138x188cm", 700.0),
("Tênis Nike Downshifter 11 Masculino", 250.0);
CREATE TABLE cliente (
    cliente_id INT NOT NULL PRIMARY KEY,
    endereco_id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id)
);
CREATE TABLE endereco (
    endereco_id INT NOT NULL PRIMARY KEY,
    cidade VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    rua VARCHAR(50) NOT NULL,
    cep VARCHAR(50) NOT NULL,
    complemento VARCHAR(50) DEFAULT ''
);

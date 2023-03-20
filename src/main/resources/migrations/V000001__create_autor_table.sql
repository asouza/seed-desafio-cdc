CREATE TABLE autor(
    id SERIAL PRIMARY KEY ,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    descricao VARCHAR(400),
    instante TIMESTAMP NOT NULL);
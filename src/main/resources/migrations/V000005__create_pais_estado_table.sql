CREATE TABLE pais(
    id SERIAL PRIMARY KEY ,
    nome VARCHAR(100) NOT NULL );

CREATE TABLE estado(
    id SERIAL PRIMARY KEY ,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(10) NOT NULL,
    pais_id INTEGER NOT NULL,
    CONSTRAINT fk_pais
          FOREIGN KEY(pais_id)
          REFERENCES pais(id));
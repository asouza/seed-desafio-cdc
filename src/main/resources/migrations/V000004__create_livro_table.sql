CREATE TABLE livro(
    id SERIAL PRIMARY KEY ,
    titulo VARCHAR(100) NOT NULL,
    resumo VARCHAR(500) NOT NULL,
    sumario TEXT NOT NULL,
    preco DECIMAL(8,2),
    numero_paginas INTEGER NOT NULL,
    isbn VARCHAR(100),
    data_publicacao TIMESTAMP,
    categoria_id INTEGER NOT NULL,
    autor_id INTEGER NOT NULL,
    instante TIMESTAMP NOT NULL,
    CONSTRAINT fk_autor
          FOREIGN KEY(autor_id)
    	  REFERENCES autor(id),
    CONSTRAINT fk_categoria
          FOREIGN KEY(categoria_id)
          REFERENCES categoria(id));
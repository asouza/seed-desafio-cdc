
CREATE TABLE comprador(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    pais_id INTEGER NOT NULL,
    estado_id INTEGER,
    telefone VARCHAR(20) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    CONSTRAINT fk_comprador_pais
        FOREIGN KEY(pais_id)
        REFERENCES pais(id),
    CONSTRAINT fk_comprador_estado
        FOREIGN KEY(estado_id)
        REFERENCES estado(id));

CREATE TABLE carrinho_compras(
    id SERIAL PRIMARY KEY,
    comprador_id INTEGER NOT NULL,
    total DECIMAL(8,2) NOT NULL,
    CONSTRAINT fk_carrinho_compras_comprador
        FOREIGN KEY(comprador_id)
        REFERENCES comprador(id));

CREATE TABLE carrinho_compras_itens(
    id SERIAL PRIMARY KEY ,
    carrinho_compra_id INTEGER NOT NULL,
    livro_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    CONSTRAINT fk_carrinho_compras_itens
        FOREIGN KEY(carrinho_compra_id)
        REFERENCES carrinho_compras(id),
    CONSTRAINT fk_itens_livro
        FOREIGN KEY(livro_id)
        REFERENCES livro(id));
CREATE TABLE cupom(
    id SERIAL PRIMARY KEY ,
    codigo VARCHAR(100) NOT NULL,
    percent Decimal(8,2) NOT NULL,
    validade TIMESTAMP NOT NULL);
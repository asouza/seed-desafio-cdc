# Seed Desafio CDC

Este projeto é uma solução para o desafio CDC, desenvolvido em Node.js/Express.

## Como executar

### 1. Clone o repositório:
```bash
git clone url-repositorio
cd seed-desafio-cdc
```

### 2. Instale as dependências:
```bash
npm install
```

### 3. Crie o arquivo `.env`:
Copie o arquivo de exemplo e ajuste as variáveis conforme necessário:
```bash
cp .env.example .env
```
Edite o arquivo `.env` com as configurações do seu ambiente.

### 4. Suba o banco de dados com Docker Compose:
```bash
docker-compose up -d
```

### 5. Execute as migrations do banco de dados:
```bash
npx prisma migrate deploy
```
ou, para ambiente de desenvolvimento:
```bash
npx prisma migrate dev
```

### 6. Compile o projeto:
```bash
npm run build
```

### 7. Execute o projeto:
```bash
npm start
```

## Estrutura do Projeto

- `src/` — Código-fonte principal
- `tests/` — Testes automatizados

## Como contribuir

1. Fork este repositório
2. Crie uma branch (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

[MIT](LICENSE)

---
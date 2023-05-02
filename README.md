# Fork repositori seed-desafio-cdc (https://github.com/asouza/seed-desafio-cdc)



## Objetivo

- Estudo e aplicação de premissas cognitive driven development.

- Praticar conceitos em exemplos


## Tasks

- [x] Setup projeto - java 17, spring 3.0.4, jpa, thymeleaf.

- [x]  Cadastro Autor deve seguir as seguintes regras:

 > É necessário cadastrar um novo autor no sistema. 
 > 
 >  Todo autor tem um nome, email e uma descrição. 
 >  
 >   Também queremos saber o instante exato que ele foi registrado.
 > 
 >  Restrições:
 > 
 >  - O instante não pode ser nulo
 >  - O email é obrigatório
 >  - O email tem que ter formato válido
 >  - O nome é obrigatório
 >  - A descrição é obrigatória e não pode passar de 400 caracteres"

- [x] Cadastro de categoria

> É necessário cadastrar uma  categoria
> 
> Toda categoria precisa de um nome
> 
> Restrições:
> 
> - O nome é obrigatório
> - O nome não pode ser duplicado
> 


- [x] Cadastro de Livro

>
> Necessidades
>  
> - Um título
> - Um resumo do que vai ser encontrado no livro
> - Um sumário de tamanho livre. O texto deve entrar no formato markdown, que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
> - Preço do livro
> - Número de páginas
> - Isbn(identificador do livro)
> - Data que ele deve entrar no ar(de publicação)
> - Um livro pertence a uma categoria
> - Um livro é de um autor
> 
> Restrições
> 
> - Título é obrigatório
> - Título é único
> - Resumo é obrigatório e tem no máximo 500 caracteres
> - Sumário é de tamanho livre.
> - Preço é obrigatório e o mínimo é de 20
> - Número de páginas é obrigatória e o mínimo é de 100
> - Isbn é obrigatório, formato livre
> - Isbn é único
> - Data que vai entrar no ar precisa ser no futuro
> - A categoria não pode ser nula
> - O autor não pode ser nulo
> 
> 
> Resultado esperado
> Um novo livro precisa ser criado e status 200 retornado
> Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação
> 

- [x] Cadastro Pais Estado:



- [x] Cadastro comprador parte 1

>
> Necessidades
> Uma coisa importante. 
> Na cdc, você não faz um cadastro e tem suas compras associadas. 
> Toda vez você coloca seu email, cpf/cnpj etc. 
> Como isso vai ser implementado depende da aplicação.
> 
> Os seguintes campos precisam ser preenchidos:
> 
> - email
> - nome
> - sobrenome
> - documento(cpf/cnpj)
> - endereco
> - complemento
> - cidade
> - pais
> - estado(caso aquele pais tenha estado)
> - telefone
> - cep
> 
> Restrição
> 
> - email obrigatório e com formato adequado
> - nome obrigatório
> - sobrenome obrigatório
> - documento(cpf/cnpj) obrigatório e só precisa ser um cpf ou cnpj
> - endereco obrigatório
> - complemento obrigatório
> - cidade obrigatório
> - país obrigatório se o país tiver estados, um estado precisa ser selecionado
> - estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados
> - telefone obrigatório
> - cep é obrigatório
> 
> Resultado esperado
> 
> Compra parcialmente gerada, mas ainda não gravada no banco de dados. Falta os dados do pedido em si que vão ser trabalhados no próximo cartão.
> 

- [ ] Carrinho de compra

>
> Necessidades
> 
> Receber também o parâmetro relativo ao carrinho de compras no formulário final. O json montado pelo cliente relativo ao carrinho tem o seguinte formato:
>
> ```
>  {
>  total": decimal,
>  "itens":[
>   {
>    "idLivro":number,
>    "quantidade": "number"
>   },
>   {
>    "idLivro":number,
>    "quantidade": number
>   }
>  ]
> }
> ```
> restrição
>  - o total é não nulo
>  - o total é maior que zero
>  - tem pelo menos um item no carrinho
>  - idLivro é obrigatório e precisa existir
>  - quantidade é obrigatória
>  - quantidade é maior que zero
>  - o total calculado no servidor precisa ser igual ao total enviado
> 
> resultado esperado
> 
> - Compra gerada com um status de iniciada
> - status 201 gerado com o endereço de detalhe da compra 

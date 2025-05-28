# Projeto Biblioteca

Um projeto Java que consome a [API do Google Books](https://developers.google.com/books/docs/v1/using) para consultar informações de livros. O programa solicita ao usuário o título de um livro, realiza uma requisição HTTP para a API e exibe dados como título, autores, editora, data de publicação, descrição, idioma, entre outros.

> **Desafio do Curso:**  
> Este projeto foi desenvolvido como um desafio proposto no curso **"Java: consumindo API, gravando arquivos e lidando com erros"** da Alura, como parte do Programa ONE.

## Tabela de Conteúdos

- [Motivação](##motivação)
- [Recursos Utilizados](#recursos-utilizados)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Exemplo de Uso](#exemplo-de-uso)
- [Melhorias Futuras](#melhorias-futuras)
- [Licença](#licença)

## Motivação

O projeto Biblioteca foi criado para praticar conceitos de programação orientada a objetos em Java, como encapsulamento e herança, além de aprender a consumir APIs REST utilizando as novas funcionalidades do Java HTTP Client. Esse desafio, proposto no curso da Alura, permitiu consolidar técnicas essenciais e explorar o uso do Gson para mapeamento de dados JSON, preparando o terreno para projetos mais avançados.

## Recursos Utilizados

- **Java 11 ou superior:** Utilizando as classes nativas de HTTP (`HttpClient`, `HttpRequest` e `HttpResponse`).
- **Gson:** Para converter o JSON retornado pela API em objetos Java.
- **Google Books API:** Requisições de busca e consulta por título de livro.
- **Encapsulamento e POO:** Organização das classes para representar os dados retornados.
- **Curso Alura - Programa ONE:** Desafio proposto no curso *"Java: consumindo API, gravando arquivos e lidando com erros"*.

## Estrutura do Projeto

A estrutura básica do projeto é a seguinte:

```
/biblioteca
│
├── Principal.java         # Classe principal que contém o método `main` e faz a requisição à API
├── Livro.java             # Classe modelo para representar um livro com atributos como título, autores, editora etc.
├── VolumeInfo.java        # Classe para mapear as informações detalhadas do livro retornadas pela API
├── Item.java              # Classe que encapsula o VolumeInfo para representar os itens retornados pela API
├── RespostaDados.java     # (Opcional) Classe para mapear a resposta completa da API, contendo a lista de itens
└── Identificadores.java   # (Opcional) Classe para mapear os identificadores, como ISBN (com possibilidade de ajustes)
```

> **Observação:**  
> A estrutura pode ser expandida conforme necessário para adicionar novos recursos ou melhorar a modularização.

## Pré-requisitos

- **Java:** Certifique-se de ter o Java 11 ou superior instalado.
- **Gson:** Se você utiliza um gerenciador de dependências (como Maven ou Gradle), adicione a dependência do Gson; caso contrário, inclua o jar do Gson no classpath.

### Exemplo de dependência Maven para Gson

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

## Como Executar

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/biblioteca.git
   ```

2. **Compile o projeto:**

   Se estiver usando o terminal:

   ```bash
   javac -d bin src/*.java
   ```

   Ou abra o projeto em sua IDE favorita e compile-o.

3. **Execute a aplicação:**

   ```bash
   java -cp bin Principal
   ```

   Ao iniciar, a aplicação solicitará que você informe o título de um livro e, em seguida, fará a consulta na API exibindo os dados do livro.

## Exemplo de Uso

Após a execução, a saída será semelhante a:

```
Digite o título do livro:
Java Programming

--- Informações do livro ---
Título: Java Programming
Autores: John Doe, Jane Smith
Editora: Editora Exemplo
Data de publicação: 2020-05-12
Descrição: Este livro aborda os principais conceitos da programação em Java...
Idioma: en
Link de prévia: https://books.google.com/...
Link de informações: https://books.google.com/...
```

## Melhorias Futuras

- **Tratamento de Erros e Exceções:** Implementar uma lógica mais robusta para casos em que a API não retorne dados ou a requisição falhe.
- **Interface Gráfica:** Desenvolver uma interface (por exemplo, utilizando JavaFX) para uma experiência de usuário mais intuitiva.
- **Novo Mapeamento de Dados:** Expandir o mapeamento para incluir informações adicionais, como ISBN e detalhes de preços.
- **Persistência de Dados:** Adicionar armazenamento local (por exemplo, usando SQLite) para salvar livros consultados.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais informações.



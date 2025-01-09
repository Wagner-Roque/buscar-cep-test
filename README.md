# buscar-cep-test
api para buscar pelo cep logradouro
1. Desenho da solução
A aplicação será dividida em camadas seguindo a arquitetura MVC (Model-View-Controller) e respeitando os princípios do SOLID.

Camadas principais:
Controller: Recebe as requisições REST e delega as ações para os serviços.
Service: Contém a lógica de negócios, faz chamadas para os repositórios e comunica-se com a API externa.
Repository: Lida com o banco de dados para salvar os logs.
Client: Faz a chamada à API externa de busca de CEP.
Entity: Representa os dados que serão persistidos no banco.
DTO: Define os dados que transitam entre as camadas.
2. Tecnologias utilizadas
Spring Boot: Para criação da API REST.
Spring Data JPA: Para persistência de dados.
H2 Database: Banco de dados em memória para persistir os logs.
WireMock: Para simular a API externa de busca de CEP.
MapStruct: Para conversão de entidades e DTOs.
Lombok: Para simplificar a escrita de código boilerplate (getters, setters, etc.).
3. Estrutura de pastas
plaintext
Copy code
src/main/java/com/exemplo/buscacep/
├── controller/
│   └── CepController.java
├── service/
│   └── CepService.java
├── repository/
│   └── LogRepository.java
├── client/
│   └── CepClient.java
├── model/
│   ├── entity/
│   │   └── LogEntity.java
│   ├── dto/
│   │   └── CepResponseDto.java
│   └── mapper/
│       └── LogMapper.java
├── config/
│   └── WireMockConfig.java
└── BuscaCepApplication.java

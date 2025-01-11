# buscar-cep-test
api para buscar pelo cep logradouro
1. Desenho da solução
A aplicação foi pensada e dividida em camadas seguindo a arquitetura MVC (Model-View-Controller) e procurei respeitar
os princípios do SOLID.

Camadas principais:
**BuscarCepController**: Recebe as requisições REST e delega as ações para os serviços.
**BuscarCepService**: Contém a lógica de negócios, faz chamadas para os repositórios para gravar no banco e faz a chamada para a API externa.
**Repository**: Lida com o banco de dados para salvar os logs, foi usado o banco relacional.
**BuscarCepClient**: Faz a chamada à API externa de busca de CEP.
**LogEntity**: Representa os dados que serão persistidos no banco.
**DTO**: Define os dados que transitam entre as camadas e retornam para o a api em json.
2. Tecnologias utilizadas
Spring Boot: Para criação da API REST.
Spring Data JPA: Para persistência de dados.
H2 Database: Banco de dados em memória para persistir os logs e em faze de testes.
PostgresSQL: Banco de dados relacional para persistir os logs.
WireMock: Para simular a API externa de busca de CEP implementando um RestTemplate.
MapStruct: Para conversão de entidades e DTOs.
Lombok: Para simplificar a escrita de código boilerplate (getters, setters, etc.).
3. Estrutura de pastas planejadas

src/main/java/com/roque/teste/act/api_busca_cep/
├── controller/
│   └── BuscarCepController.java
├── service/
│   └── BuscarCepService.java
├── repository/
│   └── LogRepository.java
├── client/
│   └── BuscarCepClient.java
├── model/
│   ├── entity/
│   │   └── LogEntity.java
│   ├── dto/
│   │   └── CepResponseDto.java
│   └── mapper/
│       └── LogMapper.java
├── config/
│   └── WireMockConfig.java
└── ApiBuscaCepApplication.java

Documentacao:

http://localhost:8080/swagger-ui/
http://localhost:15432/browser/
![](C:\Users\roque\OneDrive\Imagens\busca-cep.drawio)

<img src="C:\Users\roque\OneDrive\Imagens\busca-cep.jpg"/>
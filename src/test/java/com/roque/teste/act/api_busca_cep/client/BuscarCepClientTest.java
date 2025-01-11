package com.roque.teste.act.api_busca_cep.client;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class BuscarCepClientTest {

    private BuscarCepClient buscarCepClient;
    private RestTemplate restTemplate;

    @Value("${viaCep.url}")
    private String urlViaCep = "https://viacep.com.br/ws/";

    @BeforeEach
    void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        buscarCepClient = new BuscarCepClient(restTemplate);
        buscarCepClient.consultarCep(urlViaCep);
    }

    @Test
    void consultarCepDeveRetornarCepResponseDtoQuandoSucesso() {

        String cep = "01001000";
        String url = urlViaCep + cep + "/json";

        CepResponseDto expectedResponse = new CepResponseDto();
        expectedResponse.setCep(cep);
        expectedResponse.setLogradouro("Jd Japão");
        expectedResponse.setComplemento("lado ímpar");
        expectedResponse.setBairro("Guarapiranga");
        expectedResponse.setLocalidade("São Paulo");
        expectedResponse.setUf("SP");

        when(restTemplate.getForObject(anyString(), Mockito.eq(CepResponseDto.class)))
                .thenReturn(expectedResponse);

        CepResponseDto actualResponse = buscarCepClient.consultarCep(cep);

        assertEquals(expectedResponse.getCep(), actualResponse.getCep());
        assertEquals(expectedResponse.getLogradouro(), actualResponse.getLogradouro());
        assertEquals(expectedResponse.getComplemento(), actualResponse.getComplemento());
        assertEquals(expectedResponse.getBairro(), actualResponse.getBairro());
        assertEquals(expectedResponse.getLocalidade(), actualResponse.getLocalidade());
        assertEquals(expectedResponse.getUf(), actualResponse.getUf());
    }

}
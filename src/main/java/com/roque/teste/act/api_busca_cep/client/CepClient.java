package com.roque.teste.act.api_busca_cep.client;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CepClient {
    private final RestTemplate restTemplate;

    public CepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CepResponseDto consultarCep(String cep) {
         String url = "https://viacep.com.br/ws/"+cep+"/json";
        return restTemplate.getForObject(url, CepResponseDto.class);
    }
}

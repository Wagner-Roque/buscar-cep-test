package com.roque.teste.act.api_busca_cep.client;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BuscarCepClient {
    @Value("${viaCep.url}")
    private String urlViaCep;
    private final RestTemplate restTemplate;

    public BuscarCepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CepResponseDto consultarCep(String cep) {
         String url = urlViaCep+cep+"/json";
        return restTemplate.getForObject(url, CepResponseDto.class);
    }
}

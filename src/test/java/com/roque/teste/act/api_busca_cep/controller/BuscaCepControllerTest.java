package com.roque.teste.act.api_busca_cep.controller;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.service.BuscarCepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscaCepControllerTest {
    @Mock
    private BuscarCepService buscarCepService;

    @InjectMocks
    private BuscarCepController buscaCepController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarCepDeveRetornarCepResponseDto() {

        String cep = "01001000";
        CepResponseDto mockResponse = new CepResponseDto("01001-000", "Rua Ubacaba", "apto", "Centro", "São Paulo", "SP");

        when(buscarCepService.buscarCep(cep)).thenReturn(mockResponse);

        ResponseEntity<CepResponseDto> response = buscaCepController.buscarCep(cep);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());

           verify(buscarCepService, times(1)).buscarCep(cep);
    }
}
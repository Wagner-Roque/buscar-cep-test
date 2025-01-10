package com.roque.teste.act.api_busca_cep.controller;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.service.BuscarCepService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("api/v1/cep")
@Api(tags = "Busca CEP")
public class BuscarCepController {
    private final BuscarCepService cepService;
    @Autowired
    public BuscarCepController(BuscarCepService cepService) {
        this.cepService = cepService;
    }
    @ApiOperation(value = "Buscar informações de um CEP", notes = "Consulta uma API externa para retornar dados do CEP informado.")
    @GetMapping("{cep}")
    public ResponseEntity<CepResponseDto> buscarCep(@PathVariable String cep) {
        CepResponseDto response = cepService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }
}

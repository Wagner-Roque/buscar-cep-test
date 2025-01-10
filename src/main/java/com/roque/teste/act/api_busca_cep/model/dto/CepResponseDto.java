package com.roque.teste.act.api_busca_cep.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class CepResponseDto implements Serializable {


    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() {
        return cep == null ? "" : cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return  logradouro == null ? "" : logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento == null ? "" : complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro == null ? "" : bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade == null ? "" : localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf == null ? "" : uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public CepResponseDto(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

}

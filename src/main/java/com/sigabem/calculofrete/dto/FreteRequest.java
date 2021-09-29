package com.sigabem.calculofrete.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FreteRequest {

    @NotEmpty(message = "Preencha todos os campo")
    private String nomeDestinatario;
    @NotEmpty(message = "Preencha o campo")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
    private String cepOrigem;
    @NotEmpty(message = "Preencha o campo")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
    private String cepDestino;
    @NotNull
    private Double peso;

    public FreteRequest() {
    }

    public FreteRequest(String nomeDestinatario, String cepOrigem, String cepDestino, Double peso) {
        this.nomeDestinatario = nomeDestinatario;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}

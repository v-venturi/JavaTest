package com.sigabem.calculofrete.model;

import lombok.Data;

@Data
public class Endereco {

    private String cep;
    private String ddd;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String ddd, String uf) {
        this.cep = cep;
        this.ddd = ddd;
        this.uf = uf;
    }


    public String getCep() {
        return cep;
    }

    public String getDdd() {
        return ddd;
    }

    public String getUf() {
        return uf;
    }
}

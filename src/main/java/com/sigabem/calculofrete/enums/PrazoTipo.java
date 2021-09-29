package com.sigabem.calculofrete.enums;

public enum PrazoTipo {
    MESMO_DDD(-9),
    MESMA_UF(-7),
    UF_DIFERENTE(10);

    private int prazo;

    private PrazoTipo(int dias) {
        prazo = dias;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

}

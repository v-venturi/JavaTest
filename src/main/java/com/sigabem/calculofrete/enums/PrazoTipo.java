package com.sigabem.calculofrete.enums;

public enum PrazoTipo {
    MESMO_DDD(1),
    MESMA_UF(3),
    UF_DIFERENTE(10);

    public int prazo;

    PrazoTipo(int dias) {
        prazo = dias;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    }

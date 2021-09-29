package com.sigabem.calculofrete.enums;

public enum DescontoTipo {
    MESMO_DDD(0.5),
    MESMA_UF(0.75),
    UF_DIFERENTE(0);

    private double desconto;

    private DescontoTipo(double valor) {
        desconto = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}

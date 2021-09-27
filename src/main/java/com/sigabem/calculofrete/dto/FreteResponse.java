package com.sigabem.calculofrete.dto;



public class FreteResponse {
    private Double vlrTotalFrete;
    private String dataPrevistaEntrega;
    private String cepOrigem;
    private String cepDestino;

    public Double getVlrTotalFrete() {
        return vlrTotalFrete;
    }

    public void setVlrTotalFrete(Double vlrTotalFrete) {
        this.vlrTotalFrete = vlrTotalFrete;
    }

    public String getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
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

    public FreteResponse(Double vlrTotalFrete, String dataPrevistaEntrega, String cepOrigem, String cepDestino) {
        this.vlrTotalFrete = vlrTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
    }

    public FreteResponse() {
    }
}

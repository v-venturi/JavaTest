package com.sigabem.calculofrete.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDestinatario;
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private Double vlrTotalFrete;
    private String dataPrevistaEntrega;
    private String dataConsulta;

    public Frete(Long id, String nomeDestinatario, Double peso, String cepOrigem, String cepDestino,
                 Double vlrTotalFrete, String dataPrevistaEntrega, String dataConsulta) {
        this.id = id;
        this.nomeDestinatario = nomeDestinatario;
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.vlrTotalFrete = vlrTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataConsulta = dataConsulta;
    }

    public Frete() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Frete frete = (Frete) o;
        return Objects.equals(id, frete.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

package com.sigabem.calculofrete.service;

import com.sigabem.calculofrete.dto.FreteRequest;
import com.sigabem.calculofrete.dto.FreteResponse;
import com.sigabem.calculofrete.enums.DescontoTipo;
import com.sigabem.calculofrete.enums.PrazoTipo;
import com.sigabem.calculofrete.exceptions.CepNaoEncontradoException;
import com.sigabem.calculofrete.model.Endereco;
import com.sigabem.calculofrete.model.Frete;
import com.sigabem.calculofrete.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class FreteService {
    private final FreteRepository freteRepository;
    private final ViaCepClient viaCepClient;


    public FreteResponse calculaFrete(FreteRequest freteRequest) throws CepNaoEncontradoException {
        Endereco buscaEnderecoOrigem = viaCepClient
                .buscaEnderecoOrigem(freteRequest);
        Endereco buscaEnderecoDestino = viaCepClient
                .buscaEnderecoDestino(freteRequest);

        double precoTotal;
        Calendar dataEntrega = new GregorianCalendar();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");

        if (buscaEnderecoOrigem.getCep() == null)
            throw new CepNaoEncontradoException
                    (HttpStatus.BAD_REQUEST, " - CEP " + freteRequest.getCepOrigem() + " não existe");
        else if (buscaEnderecoDestino.getCep() == null)
            throw new CepNaoEncontradoException
                    (HttpStatus.BAD_REQUEST, " - CEP " + freteRequest.getCepDestino() + " não existe");
        else if (Objects.equals(buscaEnderecoOrigem.getDdd(), buscaEnderecoDestino.getDdd())) {
            precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.MESMO_DDD.getDesconto()));
            //colocado desconto diferente para seguir o enunciado e porque GO/DF compartilham DDD 61 em algumas cidades diferentes
            dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.MESMO_DDD.getPrazo());
        } else if (Objects.equals(buscaEnderecoOrigem.getUf(), buscaEnderecoDestino.getUf())) {
            precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.MESMA_UF.getDesconto()));
            dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.MESMA_UF.getPrazo());
        } else
            precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.UF_DIFERENTE.getDesconto()));
        dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.UF_DIFERENTE.getPrazo());

        FreteResponse freteResponse = new FreteResponse();
        freteResponse.setDataPrevistaEntrega(dataFormatada.format(dataEntrega.getTime()));
        freteResponse.setVlrTotalFrete(precoTotal);
        freteResponse.setCepDestino(freteRequest.getCepDestino());
        freteResponse.setCepOrigem(freteRequest.getCepOrigem());

        Date date = new Date();
        Frete frete = new Frete();
        frete.setNomeDestinatario(freteRequest.getNomeDestinatario());
        frete.setPeso(freteRequest.getPeso());
        frete.setCepOrigem(freteRequest.getCepOrigem());
        frete.setCepDestino(freteRequest.getCepDestino());
        frete.setVlrTotalFrete(freteResponse.getVlrTotalFrete());
        frete.setDataPrevistaEntrega(freteResponse.getDataPrevistaEntrega());
        frete.setDataConsulta(dataFormatada.format(date));

        freteRepository.save(frete);
        return freteResponse;
    }

}
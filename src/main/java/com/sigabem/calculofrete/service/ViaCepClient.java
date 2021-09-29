package com.sigabem.calculofrete.service;


import com.sigabem.calculofrete.dto.FreteRequest;
import com.sigabem.calculofrete.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepClient {

    public Endereco buscaEnderecoOrigem(FreteRequest freteRequest) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject("https://viacep.com.br/ws/" +
                        freteRequest.getCepOrigem() + "/json", Endereco.class);

    }

    public Endereco buscaEnderecoDestino(FreteRequest freteRequest) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject("https://viacep.com.br/ws/" +
                        freteRequest.getCepDestino() + "/json", Endereco.class);

    }
}

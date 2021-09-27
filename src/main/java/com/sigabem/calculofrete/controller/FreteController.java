package com.sigabem.calculofrete.controller;

import com.sigabem.calculofrete.dto.FreteRequest;
import com.sigabem.calculofrete.dto.FreteResponse;
import com.sigabem.calculofrete.service.FreteService;
import com.sigabem.calculofrete.service.ViaCepClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
//@RequestMapping("/frete")
@CrossOrigin(origins = "*")
@Api(value = "Transportadora Siga Bem - Cálculo de Frete")
public class FreteController {

    @Autowired
    private final ViaCepClient viaCepClient;
    private final FreteService freteService;

    @PostMapping("/consultafrete")
    @ApiOperation(value = "Faz a consulta de frete")
    public ResponseEntity<FreteResponse>
    consultaFrete(@RequestBody FreteRequest freteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(freteService.calculaFrete(freteRequest));
    }

}

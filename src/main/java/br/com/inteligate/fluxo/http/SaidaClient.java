package br.com.inteligate.fluxo.http;

import br.com.inteligate.fluxo.dto.SaidaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "saida-api")
public interface SaidaClient {

    @PostMapping(value = "/saida", consumes = MediaType.APPLICATION_JSON_VALUE)
    void registrarSaida(@RequestBody SaidaDTO saida);

}

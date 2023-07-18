package br.com.inteligate.fluxo.http;

import br.com.inteligate.fluxo.dto.RegistroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "carga-api")
public interface CargaClient {

    @PostMapping(value = "/registro", consumes = MediaType.APPLICATION_JSON_VALUE)
    void registrarCarga(@RequestBody RegistroDTO registro);
}

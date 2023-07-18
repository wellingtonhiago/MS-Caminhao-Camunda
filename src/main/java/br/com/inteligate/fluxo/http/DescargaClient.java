package br.com.inteligate.fluxo.http;

import br.com.inteligate.fluxo.dto.DescargaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "descarga-api")
public interface DescargaClient {

    @PostMapping(value = "/descarga", consumes = MediaType.APPLICATION_JSON_VALUE)
    void registrarDescarga(@RequestBody DescargaDTO descarga);
}

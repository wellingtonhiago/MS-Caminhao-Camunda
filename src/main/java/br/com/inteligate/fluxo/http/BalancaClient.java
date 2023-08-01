package br.com.inteligate.fluxo.http;


import br.com.inteligate.fluxo.dto.BalancaDTO;
import br.com.inteligate.fluxo.dto.PesoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "netty-server")
public interface BalancaClient {

    @PostMapping(value = "/balanca", consumes = MediaType.APPLICATION_JSON_VALUE)
    PesoDTO registrarCarga(@RequestBody BalancaDTO balanca);

}

package br.com.inteligate.fluxo.http;

import br.com.inteligate.fluxo.dto.TruckDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "caminhao-api")
public interface CaminhaoClient {

    @GetMapping("/trucks/{id}")
    TruckDTO getCargaById(@PathVariable("id") String id);

}

package br.com.inteligate.fluxo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckDTO {
    private String id;
    private String placa;
    private Double capacidade;
    private Boolean carga;
    private Boolean acesso;
}

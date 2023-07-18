package br.com.inteligate.fluxo.service;

import br.com.inteligate.fluxo.dto.DescargaDTO;
import br.com.inteligate.fluxo.dto.TruckDTO;
import br.com.inteligate.fluxo.http.CaminhaoClient;
import br.com.inteligate.fluxo.http.CargaClient;
import br.com.inteligate.fluxo.http.DescargaClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named("descarga")
class Descarga implements JavaDelegate {

    @Autowired
    private CaminhaoClient caminhaoClient;

    @Autowired
    private DescargaClient descargaClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String caminhaoId = (String) delegateExecution.getVariable("caminhaoId");
        TruckDTO caminhao = caminhaoClient.getCargaById(caminhaoId);

        DescargaDTO descarga = new DescargaDTO();
        descarga.setPlaca(caminhao.getPlaca());

        descargaClient.registrarDescarga(descarga);
        System.out.println("Descarregando caminhão");
    }
}

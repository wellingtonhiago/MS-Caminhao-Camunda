package br.com.inteligate.fluxo.service;

import br.com.inteligate.fluxo.dto.RegistroDTO;
import br.com.inteligate.fluxo.dto.TruckDTO;
import br.com.inteligate.fluxo.http.CaminhaoClient;
import br.com.inteligate.fluxo.http.CargaClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named("carregamento")
class Carregamento implements JavaDelegate {

    @Autowired
    private CaminhaoClient caminhaoClient;

    @Autowired
    private CargaClient cargaClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String caminhaoId = (String) delegateExecution.getVariable("caminhaoId");
        TruckDTO caminhao = caminhaoClient.getCargaById(caminhaoId);

        RegistroDTO registro = new RegistroDTO();
        registro.setPlaca(caminhao.getPlaca());

        cargaClient.registrarCarga(registro);
        System.out.println("Carregando caminhão");
    }
}
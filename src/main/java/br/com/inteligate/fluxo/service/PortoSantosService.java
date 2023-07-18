package br.com.inteligate.fluxo.service;

import br.com.inteligate.fluxo.dto.TruckDTO;
import br.com.inteligate.fluxo.http.CaminhaoClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named("portoSantosService")
class PortoSantosService implements JavaDelegate {

    private final CaminhaoClient caminhaoClient;

    @Autowired
    PortoSantosService(CaminhaoClient caminhaoClient) {
        this.caminhaoClient = caminhaoClient;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String caminhaoId = (String) delegateExecution.getVariable("caminhaoId");

        TruckDTO caminhao = caminhaoClient.getCargaById(caminhaoId);

        delegateExecution.setVariable("acesso", caminhao.getAcesso());
        delegateExecution.setVariable("carga", caminhao.getCarga());

        System.out.println("");
    }
}








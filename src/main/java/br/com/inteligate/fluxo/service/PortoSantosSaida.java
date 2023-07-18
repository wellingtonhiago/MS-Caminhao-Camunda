package br.com.inteligate.fluxo.service;

import br.com.inteligate.fluxo.dto.SaidaDTO;
import br.com.inteligate.fluxo.dto.TruckDTO;
import br.com.inteligate.fluxo.http.CaminhaoClient;
import br.com.inteligate.fluxo.http.SaidaClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named("portoSantosSaida")
class PortoSantosSaida implements JavaDelegate {

    @Autowired
    private CaminhaoClient caminhaoClient;

    @Autowired
    private SaidaClient saidaClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String caminhaoId = (String) delegateExecution.getVariable("caminhaoId");
        TruckDTO caminhao = caminhaoClient.getCargaById(caminhaoId);

        SaidaDTO saida = new SaidaDTO();
        saida.setPlaca(caminhao.getPlaca());

        saidaClient.registrarSaida(saida);
        System.out.println("Acesso negado");

    }
}

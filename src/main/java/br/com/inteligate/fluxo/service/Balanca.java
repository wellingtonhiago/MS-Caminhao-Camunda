package br.com.inteligate.fluxo.service;

import br.com.inteligate.fluxo.dto.BalancaDTO;
import br.com.inteligate.fluxo.dto.PesoDTO;
import br.com.inteligate.fluxo.http.BalancaClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("balanca")
public class Balanca implements JavaDelegate {

    @Autowired
    private BalancaClient balancaClient;


    @Override
    public void execute(DelegateExecution execution) throws Exception {

     //   String balanca = (String) execution.getVariable("nomeBalanca");
        String balanca = (String) execution.getVariableLocal("balancaNome");

        BalancaDTO balancaDTO = new BalancaDTO();
        balancaDTO.setNome(balanca);
        PesoDTO peso = balancaClient.registrarCarga(balancaDTO);

        execution.setVariable(execution.getVariableLocal("variavelDestino").toString(), peso.getPeso());

        System.out.println("Peso: " + peso);

    }
}

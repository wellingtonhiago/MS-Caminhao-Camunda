package br.com.inteligate.fluxo.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named("saidaPortoSantos")
class SaidaPortoSantos implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("Caminhão saiu do Porto");
    }
}

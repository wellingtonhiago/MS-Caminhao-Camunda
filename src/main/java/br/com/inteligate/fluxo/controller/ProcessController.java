package br.com.inteligate.fluxo.controller;

import br.com.inteligate.fluxo.dto.TruckDTO;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessInstanceWithVariablesImpl;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/startProcess")
    public Object startProcess(@RequestBody TruckDTO request) {

        Map<String, Object> vars = new HashMap<>();

        vars.put("caminhaoId", request.getId());

        //nome balanca
//        vars.put("balanca", "balancaNome");

        ProcessInstanceWithVariablesImpl pi = (ProcessInstanceWithVariablesImpl) runtimeService.startProcessInstanceByKey("process-porto-santos-3", vars);

        return pi.getVariables();
    }
}

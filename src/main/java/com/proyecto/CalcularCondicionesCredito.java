package com.proyecto;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Objects;

public class CalcularCondicionesCredito implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long edadSolicitante = (Long) execution.getVariable("edadSolicitante");
        String validacionHistorialCrediticio = (String) execution.getVariable("validacionHistorialCrediticio");

        Integer porcentajeInteres;
        Integer numeroCuotas;

        if (edadSolicitante > 60) {
            numeroCuotas = 24;
        }
        else if (edadSolicitante > 40) {
            numeroCuotas = 48;
        }
        else if (edadSolicitante > 30) {
            numeroCuotas = 56;
        }
        else {
            numeroCuotas = 62;
        }

        if (Objects.equals(validacionHistorialCrediticio, "Alto")){
            porcentajeInteres = 5;
        }
        else{
            porcentajeInteres = 15;
        }
        System.out.println(numeroCuotas);
        System.out.println(porcentajeInteres);
        execution.setVariable("porcentajeInteres", porcentajeInteres);
        execution.setVariable("numeroCuotas", numeroCuotas);
    }
}

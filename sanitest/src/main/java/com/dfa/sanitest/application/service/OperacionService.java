package com.dfa.sanitest.application.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.dfa.sanitest.application.repository.OperacionRepository;
import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.domain.Parametro;
import com.dfa.sanitest.infraestructure.utils.SanitestCommonUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperacionService {
    
    private final OperacionRepository repository;

    // funcionalidad principal
    public Operacion calculate (Operacion operacion) throws Exception {

        if(Objects.nonNull(operacion) && SanitestCommonUtils.checkCollection(operacion.getParameters()) 
                    && Objects.nonNull(operacion.getType())) {
            operacion.setResult(this.calculateAll(operacion.getParameters(), operacion.getType()));
            operacion.setSysDate((Objects.isNull(operacion.getSysDate())) ? LocalDateTime.now() : operacion.getSysDate());
            operacion = this.save(operacion);
        }
        return operacion;
    }

    // funcionalidades adicionales
    public Operacion findById (Long id) throws Exception {
        return repository.findById(id);
    }

    public List<Operacion> findByFilter (Operacion filter, Boolean order, Boolean asc) throws Exception {
        return repository.findAll(filter, order, asc);
    }

    public Operacion save (Operacion operacion) throws Exception {
        return repository.save(operacion);
    }

    public void deleteById (Long id) throws Exception {
        repository.deleteById(id);
    }

    // operaciones privadas
    private BigDecimal calculateAll (List<Parametro> parameters, char type) throws Exception {

        BigDecimal result = new BigDecimal(0);
        try {
            switch(type) {
                case '+'    :   result =    parameters.stream()
                                            .map(Parametro::getParameter)
                                            .reduce(BigDecimal::add)
                                            .get();
                                break;
                case '-'    :   result =    parameters.stream()
                                            .map(Parametro::getParameter)
                                            .reduce(BigDecimal::subtract)
                                            .get(); 
                                break;
                default     :   throw new RuntimeException();        
            }
        } catch (Exception e) {
            throw new Exception(e);
        } 

        return result;

    }


}

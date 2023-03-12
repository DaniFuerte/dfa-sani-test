package com.dfa.sanitest.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.dfa.sanitest.application.repository.OperacionRepository;
import com.dfa.sanitest.domain.Operacion;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperacionService {
    
    private final OperacionRepository repository;


    public Operacion calculate (Operacion operacion) throws Exception {
        if(Objects.nonNull(operacion) && Objects.nonNull(operacion.getType())) {
            operacion.setResult(this.calculateAll(operacion.getParameters(), operacion.getType()));
        }
        return operacion;
    }

    // funcionalidades adicionales
    public Operacion findById (Long id) throws Exception {
        return repository.findById(id);
    }

    public List<Operacion> findByFilter (Operacion filter, boolean order, boolean asc) throws Exception {
        return repository.findAll(filter, order, asc);
    }

    public Operacion save (Operacion operacion) throws Exception {
        return repository.save(operacion);
    }

    public void deleteById (Long id) throws Exception {
        repository.deleteById(id);
    }

    private BigDecimal calculateAll (List<BigDecimal> parameters, char type) throws Exception {

        BigDecimal result = new BigDecimal(0);
        parameters.forEach(p -> {
            switch(type) {
                case '+'    :   result.add(p);
                                break;
                case '-'    :   result.subtract(p);   
                                break;
                default     :   throw new RuntimeException();        
            }
        });

        return result;

    }

}

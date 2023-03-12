package com.dfa.sanitest.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.dfa.sanitest.application.repository.OperacionRepository;
import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.domain.Parametro;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperacionService {
    
    private final OperacionRepository repository;

    public Operacion calculate (Operacion operacion) throws Exception {
        if(Objects.nonNull(operacion) && Objects.nonNull(operacion.getType())) {
            operacion.setResult(this.calculateAll(operacion.getParameters(), operacion.getType()));
            this.save(operacion);
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
        parameters.forEach(p -> {
            switch(type) {
                case '+'    :   result.add(p.getParameter());
                                break;
                case '-'    :   result.subtract(p.getParameter());   
                                break;
                default     :   throw new RuntimeException();        
            }
        });

        return result;

    }

}

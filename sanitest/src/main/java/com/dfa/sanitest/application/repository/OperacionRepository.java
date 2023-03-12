package com.dfa.sanitest.application.repository;

import java.util.List;

import com.dfa.sanitest.domain.Operacion;

public interface OperacionRepository {
    
    Operacion findById(Long id) throws Exception ;
    List<Operacion> findAll(Operacion filter, Boolean order, Boolean asc) throws Exception;
    Operacion save (Operacion operacion) throws Exception;
    void deleteById(Long id) throws Exception;

}

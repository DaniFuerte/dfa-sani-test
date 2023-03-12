package com.dfa.sanitest.infraestructure.db.mapper;

import org.mapstruct.Mapper;

import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.infraestructure.db.dao.OperacionDao;

@Mapper(componentModel = "spring")
public interface DaoMapper {
    
    Operacion toOperacionDomain (OperacionDao operacion);
    OperacionDao toOperacionDao (Operacion operacion);

}

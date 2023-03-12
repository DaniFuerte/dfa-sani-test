package com.dfa.sanitest.infraestructure.db.mapper;

import org.mapstruct.Mapper;

import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.domain.Parametro;
import com.dfa.sanitest.infraestructure.db.dao.OperacionDao;
import com.dfa.sanitest.infraestructure.db.dao.ParametroDao;

@Mapper(componentModel = "spring")
public interface DaoMapper {
    
    Operacion toOperacionDomain (OperacionDao operacion);
    OperacionDao toOperacionDao (Operacion operacion);

    Parametro toParametroDomain (ParametroDao parametro);
    ParametroDao toParametroDao (Parametro parametro);

}

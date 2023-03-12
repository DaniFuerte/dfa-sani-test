package com.dfa.sanitest.infraestructure.rest.mapper;

import org.mapstruct.Mapper;

import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.domain.Parametro;
import com.dfa.sanitest.infraestructure.rest.dto.OperacionDto;
import com.dfa.sanitest.infraestructure.rest.dto.ParametroDto;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    
    Operacion toOperacionDomain (OperacionDto operacion);
    OperacionDto tOperacionDto (Operacion operacion);

    Parametro toParametroDomain (ParametroDto parametro);
    ParametroDto toParametroDto (Parametro parametro);

}

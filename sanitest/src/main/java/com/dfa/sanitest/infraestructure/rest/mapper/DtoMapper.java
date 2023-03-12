package com.dfa.sanitest.infraestructure.rest.mapper;

import org.mapstruct.Mapper;

import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.infraestructure.rest.dto.OperacionDto;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    
    Operacion toOperacionDomain (OperacionDto operacion);
    OperacionDto tOperacionDto (Operacion operacion);

}

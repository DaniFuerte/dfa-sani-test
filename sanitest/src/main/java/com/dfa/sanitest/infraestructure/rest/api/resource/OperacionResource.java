package com.dfa.sanitest.infraestructure.rest.api.resource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dfa.sanitest.application.service.OperacionService;
import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.infraestructure.rest.api.OperacionApi;
import com.dfa.sanitest.infraestructure.rest.dto.OperacionDto;
import com.dfa.sanitest.infraestructure.rest.mapper.DtoMapper;
import com.dfa.sanitest.infraestructure.utils.SaniTestConsts;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OperacionResource implements OperacionApi {

    private final DtoMapper mapper;
    private final OperacionService service;

    // operacion requierida en el enunciado
    
    @Override
    public ResponseEntity<OperacionDto> calculate(OperacionDto operacion) {

        try {

            operacion = mapper.tOperacionDto(service.calculate(mapper.toOperacionDomain(operacion)));
            return ResponseEntity.ok(operacion);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    // operaciones adicionales

    @Override
    public ResponseEntity<OperacionDto> findById(Long id) {

        try {
            return ResponseEntity.ok(mapper.tOperacionDto(service.findById(id)));
        } catch (Exception e) {
            return (e.getMessage().contains(SaniTestConsts.NOT_FOUND)) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                    :ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @Override
    public ResponseEntity<List<OperacionDto>> findAll(Boolean order, Boolean asc, Character type, BigDecimal result, LocalDateTime sysDate) {

        List<OperacionDto> finalResult          =   new ArrayList<>();

        try {
            
            OperacionDto        filter          =   new OperacionDto(null,null,type,sysDate,result);
            List<Operacion>     resultList      =   service.findByFilter(mapper.toOperacionDomain(filter), order, asc);
            resultList.forEach(item -> finalResult.add(mapper.tOperacionDto(item)));
            return ResponseEntity.ok(finalResult);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @Override
    public ResponseEntity<OperacionDto> update(Long id, OperacionDto operacion) {

        try {

            if(Objects.isNull(id) || Objects.isNull(operacion.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            if(!id.equals(operacion.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            service.findById(id);
            operacion = mapper.tOperacionDto(service.calculate(mapper.toOperacionDomain(operacion)));
            return ResponseEntity.ok(operacion);
            

        } catch (Exception e) {
            return (e.getMessage().contains(SaniTestConsts.NOT_FOUND)) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
            :ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @Override
    public ResponseEntity<OperacionDto> deleteById(Long id) {

        try {
            
            OperacionDto operacionDB = mapper.tOperacionDto(service.findById(id));
            service.deleteById(id);
            return ResponseEntity.ok(operacionDB);

        } catch (Exception e) {
            return (e.getMessage().contains(SaniTestConsts.NOT_FOUND)) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
            :ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    
}

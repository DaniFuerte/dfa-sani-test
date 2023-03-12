package com.dfa.sanitest.infraestructure.rest.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dfa.sanitest.infraestructure.rest.dto.OperacionDto;
import com.dfa.sanitest.infraestructure.utils.SaniTestConsts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;

@CrossOrigin
@Api(value = "OperacionApi")
@RequestMapping("/operacion")
@SwaggerDefinition(schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS})
public interface OperacionApi {

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca un registro por su ID", response = ResponseEntity.class, nickname = "Operacion.findById")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operacion.findById devuelve el registro buscado", response = OperacionDto.class),
        @ApiResponse(code = 404, message = "Operacion.findById no devuelve ningun registro"),
        @ApiResponse(code = 500, message = "Operacion.findById error interno del servidor")
    })
    public ResponseEntity<OperacionDto> findById(@PathVariable("id") Long id);


    @GetMapping()
    @ApiOperation(value = "Busca un conjunto de registros por un filtro", response = ResponseEntity.class, nickname = "Operacion.findAll")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operacion.findAll encuentra un conjunto de regsitros", response = OperacionDto.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Operacion.findAll error interno del servidor")
    })
    public ResponseEntity<List<OperacionDto>> findAll (@RequestParam(name = "order", required = false) Boolean order,
                                @RequestParam(name = "asc", required = false) Boolean asc,
                                @RequestParam(name = "type", required = false) Character type, 
                                @RequestParam(name = "result", required = false) BigDecimal result, 
                                @RequestParam(name = "sysDate", required = false)  @DateTimeFormat(pattern = SaniTestConsts.DATE_FORMAT) LocalDateTime sysDate);
    

    @PostMapping()
    @ApiOperation(value = "Calcula una operación a partir de un conjunto de parámetros", response = ResponseEntity.class, nickname = "Operacion.calculate")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operacion.calculate la operación termina OK", response = OperacionDto.class),
        @ApiResponse(code = 500, message = "Operacion.calculate error interno del servidor")
    })
    public ResponseEntity<OperacionDto> calculate(@RequestBody OperacionDto operacion);

    @PatchMapping("{id}")
    @ApiOperation(value = "Actualiza o Recalcula una operación a partir de un conjunto de parámetros nuevos", response = ResponseEntity.class, nickname = "Operacion.update")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operacion.update la operación termina OK", response = OperacionDto.class),
        @ApiResponse(code = 404, message = "Operacion.update el registro a actualizar o recalcular no existe"),
        @ApiResponse(code = 409, message = "Operacion.update conflito en la parametrización de entrada"),
        @ApiResponse(code = 500, message = "Operacion.update error interno del servidor")
    })
    public ResponseEntity<OperacionDto> update (@PathVariable("id") Long id, @RequestBody OperacionDto operacion);

    @DeleteMapping("{id}")
    @ApiOperation(value = "Elimina un registro por su ID", response = ResponseEntity.class, nickname = "Operacion.deleteById")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operacion.deleteById devuelve el registro eliminado", response = OperacionDto.class),
        @ApiResponse(code = 404, message = "Operacion.deleteById el registro a eliminar no existe"),
        @ApiResponse(code = 500, message = "Operacion.deleteById error interno del servidor")
    })
    public ResponseEntity<OperacionDto> deleteById (@PathVariable("id") Long id);
    
}

package com.dfa.sanitest.infraestructure.rest.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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

@RequestMapping("/operacion")
public interface OperacionApi {

    @GetMapping("/{id}")
    ResponseEntity<OperacionDto> findById(@PathVariable("id") Long id);

    @GetMapping()
    ResponseEntity<List<OperacionDto>> findAll (@RequestParam(name = "order", required = false) Boolean order,
                                @RequestParam(name = "asc", required = false) Boolean asc,
                                @RequestParam(name = "type", required = false) Character type, 
                                @RequestParam(name = "result", required = false) BigDecimal result, 
                                @RequestParam(name = "sysDate", required = false)  @DateTimeFormat(pattern = SaniTestConsts.DATE_FORMAT) LocalDateTime sysDate);
    

    @PostMapping()
    ResponseEntity<OperacionDto> calculate(@RequestBody OperacionDto operacion);

    @PatchMapping("{id}")
    ResponseEntity<OperacionDto> update (@PathVariable("id") Long id, @RequestBody OperacionDto operacion);

    @DeleteMapping("{id}")
    ResponseEntity<OperacionDto> deleteById (@PathVariable("id") Long id);
    
}

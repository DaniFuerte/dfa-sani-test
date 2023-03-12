package com.dfa.sanitest.infraestructure.rest.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ParametroDto implements Serializable {

    private Long                id;
    private BigDecimal          parameter;

    @JsonIgnore
    private OperacionDto        operacion;
    
}

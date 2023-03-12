package com.dfa.sanitest.infraestructure.rest.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class OperacionDto implements Serializable {
    
    private Long                id;
    private List<ParametroDto>    parameters;
    private Character           type;
    private BigDecimal          result;
    private LocalDateTime       sysDate;

}

package com.dfa.sanitest.infraestructure.db.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OperacionDao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                id;

    @Column
    @ElementCollection(targetClass=BigDecimal.class)
    private List<BigDecimal>    parameters;

    private Character           type;
    private BigDecimal          result;
    private LocalDateTime       sysDate;

}

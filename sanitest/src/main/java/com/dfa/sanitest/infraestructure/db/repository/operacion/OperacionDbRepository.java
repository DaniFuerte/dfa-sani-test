package com.dfa.sanitest.infraestructure.db.repository.operacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.dfa.sanitest.application.repository.OperacionRepository;
import com.dfa.sanitest.domain.Operacion;
import com.dfa.sanitest.infraestructure.db.dao.OperacionDao;
import com.dfa.sanitest.infraestructure.db.mapper.DaoMapper;
import com.dfa.sanitest.infraestructure.db.spec.OperacionSpecification;
import com.dfa.sanitest.infraestructure.utils.SaniTestConsts;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperacionDbRepository implements OperacionRepository {

    private final DaoMapper mapper;
    private final OperacionDataRepository repository;

    @Override
    public Operacion findById(Long id) throws Exception {
        return (Objects.nonNull(id)) ? mapper.toOperacionDomain(this.findByPK(id)) : null;
    }

    @Override
    public List<Operacion> findAll(Operacion filter, Boolean order, Boolean asc) throws Exception {
        
        asc = checkOrderParameters(order, asc);
        List<Operacion> result  = new ArrayList<>();
        List<OperacionDao> list = repository.findAll(OperacionSpecification.buildFilter(mapper.toOperacionDao(filter), order, asc));
        list.forEach(o -> result.add(mapper.toOperacionDomain(o)));
        return result;

    }

    @Override
    public Operacion save(Operacion operacion) throws Exception {
        return (Objects.nonNull(operacion)) ? mapper.toOperacionDomain(repository.saveAndFlush(mapper.toOperacionDao(operacion))) : null;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if(Objects.nonNull(id)) {
            repository.deleteById(id);
        }
    }

    private OperacionDao findByPK (Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception(SaniTestConsts.NOT_FOUND));
    }

    private Boolean checkOrderParameters (Boolean order, Boolean asc) {
        return (Objects.nonNull(order) && Objects.isNull(asc)) ? true : asc;
    }
    
}

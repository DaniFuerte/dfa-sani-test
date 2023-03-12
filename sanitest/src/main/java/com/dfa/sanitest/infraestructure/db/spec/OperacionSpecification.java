package com.dfa.sanitest.infraestructure.db.spec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.dfa.sanitest.infraestructure.db.dao.OperacionDao;
import com.dfa.sanitest.infraestructure.db.dao.OperacionDao_;

public class OperacionSpecification {
    
    public static Specification<OperacionDao> buildFilter (OperacionDao filter, boolean order, boolean asc) throws Exception {

        try {

            return (root,cq,cb) -> {

                List<Predicate> predicateList   =   new ArrayList<>();

                if(Objects.nonNull(filter)) {
                    if(Objects.nonNull(filter.getType())) {
                        predicateList.add(cb.equal(root.get(OperacionDao_.type), filter.getType()));
                    }
                    if(Objects.nonNull(filter.getResult())) {
                        predicateList.add(cb.equal(root.get(OperacionDao_.result), filter.getResult()));
                    }
                    if(Objects.nonNull(filter.getSysDate())) {
                        predicateList.add(cb.lessThanOrEqualTo(root.get(OperacionDao_.sysDate), filter.getSysDate()));
                    }
                }

                if(order) {
                    Order sort = (asc) ? cb.asc(root.get(OperacionDao_.sysDate)) : cb.desc(root.get(OperacionDao_.sysDate));
                    cq.orderBy(sort);
                }

                Predicate [] predicateArray = predicateList.toArray(new Predicate[predicateList.size()]);
                return cb.and(predicateArray);

            };

        } catch (Exception e) {
            throw e;
        }    

    }

}

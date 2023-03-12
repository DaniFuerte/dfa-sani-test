package com.dfa.sanitest.infraestructure.db.repository.parametro;

import com.dfa.sanitest.infraestructure.db.dao.ParametroDao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface ParametroDataRepository extends JpaRepository<ParametroDao,Long>, JpaSpecificationExecutor<ParametroDao> {
    
}

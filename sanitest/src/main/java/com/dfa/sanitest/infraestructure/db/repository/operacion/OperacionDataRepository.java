package com.dfa.sanitest.infraestructure.db.repository.operacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dfa.sanitest.infraestructure.db.dao.OperacionDao;

@Repository
public interface OperacionDataRepository extends JpaRepository<OperacionDao,Long>, JpaSpecificationExecutor<OperacionDao> {
    
}

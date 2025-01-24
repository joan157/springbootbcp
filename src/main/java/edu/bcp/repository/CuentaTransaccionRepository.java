package edu.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bcp.entity.CuentaTransaccionEntity;

public interface CuentaTransaccionRepository extends JpaRepository<CuentaTransaccionEntity, Integer>{
    
}

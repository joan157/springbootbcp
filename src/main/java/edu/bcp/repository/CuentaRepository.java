package edu.bcp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bcp.entity.CuentaEntity;


public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer>{
    
    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    public abstract List<CuentaEntity> listarCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE SALDO>3000", nativeQuery =true)
    public abstract List<CuentaEntity> listarCuentasMayoresTresmil();

    @Query(value = "SELECT * FROM CUENTA WHERE saldo BETWEEN ?1 AND ?2", nativeQuery =true)
    public abstract List<CuentaEntity> listarCuentasRango(Integer desde, Integer hasta);


    
    @Query(value = " SELECT *, CASE WHEN SALDO < (SELECT AVG(cuenta.saldo) FROM CUENTA) THEN 'BAJO EL PROMEDIO TOTAL'"+
                                    "WHEN SALDO > (SELECT AVG(cuenta.saldo) FROM CUENTA) THEN 'SOBRE EL PROMEDIO TOTAL'"+
                                    "ELSE 'IGUAL AL PROMEDIO' END AS estado "+
                    "FROM CUENTA", nativeQuery = true)
    
    public abstract List<CuentaEntity> listarCuentasEstado();

}

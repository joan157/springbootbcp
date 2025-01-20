package edu.bcp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.bcp.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
    
    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    public abstract List<ClienteEntity> listarCLientes();

    @Query(value = "SELECT * FROM CLIENTE WHERE idcliente = ?1", nativeQuery = true)
    public abstract ClienteEntity listarClienteXID(Integer idcliente);

    

}

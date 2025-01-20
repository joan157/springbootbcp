package edu.bcp.service;

import java.util.List;



import edu.bcp.entity.ClienteEntity;

public interface ClienteService {

     public abstract List<ClienteEntity> listarCLientes();
    public abstract ClienteEntity listarClienteXID(Integer idcliente);
}

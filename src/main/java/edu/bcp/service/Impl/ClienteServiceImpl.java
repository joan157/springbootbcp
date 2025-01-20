package edu.bcp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bcp.entity.ClienteEntity;
import edu.bcp.repository.ClienteRepository;
import edu.bcp.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<ClienteEntity> listarCLientes() {
        return clienteRepository.listarCLientes();
    }

    @Override
    public ClienteEntity listarClienteXID(Integer idcliente) {
       return clienteRepository.listarClienteXID(idcliente);
    }
    
}

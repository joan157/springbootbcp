package edu.bcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bcp.entity.ClienteEntity;
import edu.bcp.service.ClienteService;

@RestController
@RequestMapping("api/bcpP/v1/cliente")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listarCliente(){
        return clienteService.listarCLientes();
    }
    @GetMapping("/{idcliente}")
    public ClienteEntity listarClientexId(@PathVariable Integer idcliente){
        return clienteService.listarClienteXID(idcliente);
    }

}

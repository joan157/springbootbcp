package edu.bcp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bcp.entity.CuentaTransaccionEntity;
import edu.bcp.repository.CuentaTransaccionRepository;
import edu.bcp.service.CuentaTransaccionService;

@Service
public class CuentaTransaccionServiceImpl implements CuentaTransaccionService {

    @Autowired
    CuentaTransaccionRepository cuentaTransaccionRepository;

    @Override
    public void insertarCuentaTransaccion(CuentaTransaccionEntity cuentatra) {
       cuentaTransaccionRepository.save(cuentatra);
    }
    
}

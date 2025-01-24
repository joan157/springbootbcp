package edu.bcp.service;

import java.util.List;

import edu.bcp.dto.CuentaDTO;
import edu.bcp.entity.CuentaEntity;


public interface CuentaService {

    
     public abstract List<CuentaDTO> listarCuentas();
     public abstract List<CuentaDTO> listarCuentasMayoresTresmil();
     public abstract List<CuentaDTO> listarCuentasRango(Integer desde, Integer hasta);
     public abstract List<CuentaDTO> listarCuentasEstado();
     public abstract CuentaEntity obtenerCuentaInfo(Integer idcuenta);

     public abstract void enviarSaldo(Double monto, CuentaEntity cuenta, Integer idcuentaDestino);
     

}

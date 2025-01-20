package edu.bcp.service.Impl;

import java.util.List;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bcp.dto.CuentaDTO;
import edu.bcp.entity.CuentaEntity;
import edu.bcp.mapper.CuentaMapper;
import edu.bcp.repository.CuentaRepository;
import edu.bcp.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository; // Implementacion del repository de cuenta

    private CuentaMapper mapper = Mappers.getMapper(CuentaMapper.class);

    @Override
    public List<CuentaDTO> listarCuentas() {
        List<CuentaDTO> cuentas=  mapper.convertirListEntityADTO(cuentaRepository.listarCuentas());
        cuentas.forEach( valor -> valor.setCliente(null));
        return cuentas;

         /* List<CuentaDTO> cuentas = cuentaService.listarCuentas();
        cuentas.forEach( valor -> valor.setCliente(null));
        return cuentas;
        */

        //1.- otra manera en vez de poner la anotacion ignorejson
          // Configurar cada objeto para que no incluya el cliente
          /*cuentas.forEach(cuenta -> cuenta.setCliente(null));*/

          //2.- Otra manera , Eliminar todo pero dejar un atributo en especifico, en este caso el nombre del cliente
          /*
           * 
           * cuentas.forEach(cuenta -> {
        cuenta.setCliente(null); // Ignorar el cliente completo
        if (cuenta.getCliente() != null) {
            cuenta.setNombre(cuenta.getCliente().getNombre());
        }
    });
           * 
           */
    }

    @Override
    public List<CuentaDTO> listarCuentasMayoresTresmil() {
        return mapper.convertirListEntityADTO(cuentaRepository.listarCuentasMayoresTresmil());
    }

    @Override
    public List<CuentaDTO> listarCuentasRango(Integer desde, Integer hasta) {
        return mapper.convertirListEntityADTO(cuentaRepository.listarCuentasRango(desde, hasta));
    }

    @Override
    public List<CuentaDTO> listarCuentasEstado() {
        List<CuentaEntity> cuentaentit = cuentaRepository.listarCuentasEstado();
       return mapper.convertirListEntityADTO(cuentaentit);  
    }
    
    
    


}

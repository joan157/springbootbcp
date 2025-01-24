package edu.bcp.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bcp.dto.CuentaDTO;
import edu.bcp.entity.CuentaEntity;
import edu.bcp.entity.CuentaTransaccionEntity;
import edu.bcp.mapper.CuentaMapper;
import edu.bcp.repository.CuentaRepository;
import edu.bcp.repository.CuentaTransaccionRepository;
import edu.bcp.service.CuentaService;
import edu.bcp.service.CuentaTransaccionService;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository; // Implementacion del repository de cuenta

    @Autowired
    private CuentaTransaccionService cuentaTransaccionService;


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
        return mapper.convertirListEntityADTO(cuentaRepository.listarCuentasMayoresTresmil())
               .stream().filter(valor -> valor.getIdcuenta()%2!=0)
               .collect(Collectors.toList());
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

    @Override
    public void enviarSaldo(Double monto, CuentaEntity cuenta, Integer idcuentaDestino) {
     // actualizar saldo de la cuenta
       CuentaEntity saldoUp = new CuentaEntity(cuenta.getIdcuenta(), 
       cuenta.getSaldo() - monto, cuenta.getMoneda(), cuenta.getCliente());
       cuentaRepository.save(saldoUp);

    // registro de la transaccionCuentaTransaccionEntity(), cuenta.getIdcuenta(), new
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        cuentaTransaccionService.insertarCuentaTransaccion(new CuentaTransaccionEntity(null, 
        cuenta.getCliente(), saldoUp, monto, idcuentaDestino, fechaHoraActual));

    // actualizar idcuenta destino
        CuentaEntity cuentaDestino = cuentaRepository.findById(idcuentaDestino).orElse(null);
        if(cuentaDestino!=null){
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            cuentaRepository.save(cuentaDestino);
        }else{
            System.out.println("Cuenta destino no encontrada");
        }
        // actualizar saldo de la cuenta destino


      /*   System.out.println();
        System.out.println(saldoUp.toString() +" Cuenta Destino = "+idcuentaDestino); */
      

      

    }

    @Override
    public CuentaEntity obtenerCuentaInfo(Integer idcuenta) {
      return cuentaRepository.obtenerCuentaInfo(idcuenta);
    }
    
    
    


}

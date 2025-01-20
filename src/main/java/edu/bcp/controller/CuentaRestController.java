package edu.bcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.bcp.dto.CuentaDTO;
import edu.bcp.service.CuentaService;

@RestController
@RequestMapping("api/bcpP/v1/cuenta")
public class CuentaRestController {
    
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<CuentaDTO> listarCuentas(){

       return cuentaService.listarCuentas();
      
    }
    @GetMapping("/maxtheemil")
    public List<CuentaDTO> listarCuentasmayorestresmil(){
        return cuentaService.listarCuentasMayoresTresmil();
    }
    // http://localhost:8080/api/bcpP/v1/cuenta?desde=2000&hasta=8000
    @GetMapping(params = {"desde","hasta"})
    public List<CuentaDTO>listarCuentasentrerangos(@RequestParam Integer desde, @RequestParam Integer hasta){
        return cuentaService.listarCuentasRango(desde, hasta);
    }

    @GetMapping("/cuentaestado")
    public List<CuentaDTO> listarCuentasestado(){
        return cuentaService.listarCuentasEstado();
    }


}

package edu.bcp.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    
    public CuentaDTO(Integer idcuenta, Double saldo, String moneda, Integer idcliente){
        this.idcuenta = idcuenta;
        this.saldo = saldo;
        this.moneda = moneda;
        this.idcliente = idcliente;
    }

    public CuentaDTO(Integer idcuenta, Double saldo, String moneda, Integer idcliente, String estado){
        this.idcuenta = idcuenta;
        this.saldo = saldo;
        this.moneda = moneda;
        this.idcliente = idcliente;
        this.estado = estado;
    }

    private Integer idcuenta;
   
    private Double saldo;
  
    private String moneda;
    
   // @JsonIgnore // Esto evitará que el campo cliente se serialice en el JSON
   @JsonInclude(JsonInclude.Include.NON_NULL) // Si este campo es nulo no se serializa, en caso contrario se muestra
   private ClienteDTO cliente;

    private Integer idcliente;

    private String estado;

}

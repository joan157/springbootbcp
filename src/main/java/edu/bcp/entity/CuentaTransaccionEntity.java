package edu.bcp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cuentatransaccion")
public class CuentaTransaccionEntity {
    
    /*
     * La relación es de uno a muchos, donde una transacción (CuentaTransaccionEntity) está asociada a un cliente 
     * (ClienteEntity) y a una cuenta (CuentaEntity). 
     * Un cliente puede tener muchas transacciones, y una cuenta también puede tener muchas transacciones.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransaccion")
    private Integer idtransaccion;

    @ManyToOne
    @JoinColumn(name = "idcliente", updatable = false, nullable = false)    
    private ClienteEntity cliente;  
    
    @ManyToOne
    @JoinColumn(name = "idcuenta", updatable = false, nullable = false)
    private CuentaEntity cuenta;

    @Column(name = "montotranferido")
    private Double montotranferido; 

    @Column(name = "idclientedestino")
    private Integer idclienteDestino;

    @Column(name = "fechahora")
    private LocalDateTime fechahora;

    
}

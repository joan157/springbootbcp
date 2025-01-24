package edu.bcp.entity;
import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuenta")
public class CuentaEntity {
    
    public CuentaEntity(Integer idcuenta, Double saldo, String moneda, ClienteEntity cliente){
        this.idcuenta = idcuenta;
        this.saldo = saldo;
        this.moneda = moneda;
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcuenta")
    private Integer idcuenta;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "moneda")
    private String moneda;
    /*
     *  @ManyToOne //Muchos productos están asociados a una sola categoría.
    @JoinColumn(name = "idcategoria", updatable = false, nullable = false)   
    // @JsonIgnore  // Esto evitará que la categoría se serialice en el JSON
    //@XmlTransient // Esto evita que se serialice en XML

     * 
     */
    @ManyToOne
    @JoinColumn(name = "idcliente", updatable = false, nullable = false)
    private ClienteEntity cliente;

    @Transient
    private String estado;

    @Autowired
    public String toString(){
        return "CuentaEntity [idcuenta = " + idcuenta + ", saldo=" + saldo+
        ", moneda = " + moneda + ", cliente = " + cliente + ", estado = " + estado
        + "]";
    }
}

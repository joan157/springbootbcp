package edu.bcp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * Los entity solo interactua con el Repository y acceso a datos
 * 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

  
    private Integer idcliente;

   
    private String tipodocumento;

    
    private String numerodocumento;

   
    private String nombre;

   
    private String apellido;

  
    private Date fechanacimiento;

    
    private String correo;

    
    private String telefono;

    



}

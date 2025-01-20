package edu.bcp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.bcp.dto.CuentaDTO;
import edu.bcp.entity.CuentaEntity;

@Mapper
public interface CuentaMapper {
    
    public CuentaEntity convertirDTOAEntity(CuentaDTO cuenta);
    
    @Mapping(target = "idcliente", source = "cliente.idcliente")
    @Mapping(target = "estado", source = "estado") // Mapea directamente el campo estado
    public CuentaDTO convertirEntityADTO(CuentaEntity cuenta);

    public List<CuentaEntity> convertirListDTOAEntity(List<CuentaDTO> lista);

    @Mapping(target = "idcliente", source = "cliente.idcliente") // personalizando para que el idcliente se llene con el cliente.idcliente
    public List<CuentaDTO> convertirListEntityADTO(List<CuentaEntity> lista);

}

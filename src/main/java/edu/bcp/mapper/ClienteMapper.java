package edu.bcp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.bcp.dto.ClienteDTO;
import edu.bcp.entity.ClienteEntity;

@Mapper
public interface ClienteMapper {
    
    public ClienteEntity convertirDTOAEntity(ClienteDTO cliente);

    public ClienteDTO convertirEntityADTO(ClienteEntity cliente);

    public List<ClienteEntity> convertirListDTOAEntity(List<ClienteDTO> lista);

    public List<ClienteDTO> convertirListEntityADTO(List<ClienteEntity> lista);
}

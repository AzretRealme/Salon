package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.ClientDto;
import first.salon.salonservice.models.enitities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    default ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setPhone(client.getPhone());
        clientDto.setPin(client.getPin());
        return clientDto;
    }

    default Client toClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setPin(clientDto.getPin());
        return client;
    }

    List<ClientDto> toClientDtoList(List<Client> clientList);
    List<Client> toClientList(List<ClientDto> clientDtoList);

}


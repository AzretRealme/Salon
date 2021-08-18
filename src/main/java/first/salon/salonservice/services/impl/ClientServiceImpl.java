package first.salon.salonservice.services.impl;

import first.salon.salonservice.dao.ClientRepo;
import first.salon.salonservice.mappers.ClientMapper;
import first.salon.salonservice.models.dtos.ClientDto;
import first.salon.salonservice.models.enitities.Client;
import first.salon.salonservice.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepo clientRepo;

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        client = clientRepo.save(client);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return null;
    }

    @Override
    public ClientDto findById(Long id) {
        return ClientMapper.INSTANCE.toClientDto(clientRepo.findById(id).orElseThrow(() -> new RuntimeException("Client not found!!!")));    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }
}

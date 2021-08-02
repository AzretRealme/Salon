package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.ClientRepo;
import kg.easy.salonservice.mappers.ClientMapper;
import kg.easy.salonservice.models.dtos.ClientDto;
import kg.easy.salonservice.models.enitities.Client;
import kg.easy.salonservice.services.ClientService;
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
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }
}

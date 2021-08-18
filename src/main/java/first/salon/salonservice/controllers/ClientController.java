package first.salon.salonservice.controllers;

import first.salon.salonservice.models.dtos.ClientDto;
import first.salon.salonservice.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController implements BaseCrudController<ClientDto,Long> {

    private ClientService clientService;
    @Override
    public ClientDto save(ClientDto clientDto) {

            return clientService.save(clientDto);
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

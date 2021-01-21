package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.client.CreateClientReq;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepo){
        this.clientRepository = clientRepo;
    }

    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client saveClient(CreateClientReq createClientReq) {
        boolean status = false;
        log.info("CCR: " + createClientReq);
        String active = createClientReq.getClientActive();
        if(active.equalsIgnoreCase("active")){
            status = true;
        }
        Client client = new Client(createClientReq.getClientName(), status);
        return clientRepository.save(client);
    }

    public Optional<Client> getClient(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    public Client switchStatus(Client client) {
        client.setActiveClient(!client.isActiveClient());
        clientRepository.save(client);
        return client;
    }
}

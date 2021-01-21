package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.UpdateClientReq;
import com.enservsolutions.dig.dto.client.CreateClientReq;
import com.enservsolutions.dig.dto.client.CreateClientRes;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @PostMapping()
    public ResponseEntity<CreateClientRes> createClient(@RequestBody CreateClientReq createClientReq ) {
        Client client = clientService.saveClient(createClientReq);
        CreateClientRes response = new CreateClientRes(client.getClientName(), client.isActiveClient());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("update")
    public ResponseEntity<Client> updateClientStatus(@RequestBody UpdateClientReq updateClientReq) {
        Optional<Client> client = clientService.getClient(updateClientReq.getClientId());
        if(client.isPresent()) {
            clientService.switchStatus(client.get());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client.get());
    }

}

package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.client.CreateClientReq;
import com.enservsolutions.dig.dto.client.CreateClientRes;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}

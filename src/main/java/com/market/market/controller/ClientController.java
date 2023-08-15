package com.market.market.controller;

import com.market.market.entity.ClientEntity;
import com.market.market.repository.ClientRepository;
import com.market.market.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;

    @GetMapping("/Clients")
    public ResponseEntity<List<ClientEntity>> findAll(){
        List<ClientEntity> findClients = clientService.findClients();
        return ResponseEntity.status(HttpStatus.OK).body(findClients);
    }

    @GetMapping("/client/{id}")
    public  ResponseEntity<ClientEntity> findOne(@PathVariable Long id){
        ClientEntity findClient = clientService.findClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(findClient);
    }

    @PostMapping("/registerClient")
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity clientEntity){
        ClientEntity registerClient = clientService.registerClient(clientEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerClient);
    }

    @PutMapping("/updateClient")
    public ResponseEntity<ClientEntity> update (@PathVariable Long id, @RequestBody ClientEntity clientEntity){
        ClientEntity updateClient = clientService.updateClient(id, clientEntity);
        return ResponseEntity.status(HttpStatus.OK).body(updateClient);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.deleteRegisterClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

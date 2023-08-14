package com.market.market.controller;

import com.market.market.entity.ClientEntity;
import com.market.market.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/Clients")
    public ResponseEntity<List<ClientEntity>> findAll(){
        List<ClientEntity> findClients = clientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findClients);
    }

    @GetMapping("/client/{id}")
    public  ResponseEntity<ClientEntity> findOne(@PathVariable Long id){
        ClientEntity findClient = clientRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(findClient);
    }

    @PostMapping("/registerClient")
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity clientEntity){
        ClientEntity registerClient = clientRepository.save(clientEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerClient);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

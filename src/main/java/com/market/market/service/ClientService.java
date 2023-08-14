package com.market.market.service;

import com.market.market.entity.ClientEntity;
import com.market.market.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List <ClientEntity> findClients(){
        return clientRepository.findAll();
    }

    public ClientEntity findClient(Long id){
        return clientRepository.findById(id).get();
    }

    public ClientEntity registerClient(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }

    public void deleteRegisterClient(Long id){
        clientRepository.deleteById(id);
    }

}

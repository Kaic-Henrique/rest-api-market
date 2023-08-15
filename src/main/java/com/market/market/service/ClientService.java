package com.market.market.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.market.market.entity.ClientEntity;
import com.market.market.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    public ClientEntity updateClient(Long id, ClientEntity newClient){
        ClientEntity currentClient = clientRepository.findById(id).get();
        BeanUtils.copyProperties(currentClient, newClient,"id");
        return clientRepository.save(currentClient);
    }

    public void deleteRegisterClient(Long id){
        clientRepository.deleteById(id);
    }

}

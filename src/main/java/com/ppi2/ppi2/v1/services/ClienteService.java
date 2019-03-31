package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Cliente;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente findById(Integer id){
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        if(cliente == null)
            throw new ObjectNotFoundException();
        return cliente;
    }

    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

}

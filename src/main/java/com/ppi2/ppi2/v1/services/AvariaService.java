package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Avaria;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.AvariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvariaService {

    @Autowired
    private AvariaRepository avariaRepository;

    public List<Avaria> findAll(){
        return this.avariaRepository.findAll();
    }

    public Avaria findById(Integer id){
        Avaria avaria = this.avariaRepository.findById(id).orElse(null);
        if(avaria == null)
            throw new ObjectNotFoundException();
        return avaria;
    }

    public Avaria save(Avaria avaria){
        return this.avariaRepository.save(avaria);
    }

    public void delete(Avaria avaria){
        this.avariaRepository.delete(avaria);
    }

}

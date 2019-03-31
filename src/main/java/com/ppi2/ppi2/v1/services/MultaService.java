package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Multa;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    public List<Multa> findAll(){
        return this.multaRepository.findAll();
    }

    public Multa findById(Integer id){
        Multa multa = this.multaRepository.findById(id).orElse(null);
        if(multa == null)
            throw new ObjectNotFoundException();
        return multa;
    }

    public Multa save(Multa multa){
        return this.multaRepository.save(multa);
    }

    public void delete(Multa multa){
        this.multaRepository.delete(multa);
    }

}

package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Veiculo;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        return this.veiculoRepository.findAll();
    }

    public Veiculo findById(Integer id){
        Veiculo veiculo = this.veiculoRepository.findById(id).orElse(null);
        if(veiculo == null)
            throw new ObjectNotFoundException();
        return veiculo;
    }

    public Veiculo save(Veiculo veiculo){
        return this.veiculoRepository.save(veiculo);
    }

    public void delete(Veiculo veiculo){
        this.veiculoRepository.delete(veiculo);
    }

}

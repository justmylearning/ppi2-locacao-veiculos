package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Funcionario;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findById(Integer id){
        Funcionario funcionario = this.funcionarioRepository.findById(id).orElse(null);
        if(funcionario == null)
            throw new ObjectNotFoundException();
        return funcionario;
    }

    public Funcionario save(Funcionario funcionario){
        return this.funcionarioRepository.save(funcionario);
    }

    public void delete(Funcionario funcionario){
        this.funcionarioRepository.delete(funcionario);
    }

}

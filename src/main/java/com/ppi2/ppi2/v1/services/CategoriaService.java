package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Categoria;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return this.categoriaRepository.findAll();
    }

    public Categoria findById(Integer id){
        Categoria categoria = this.categoriaRepository.findById(id).orElse(null);
        if(categoria == null)
            throw new ObjectNotFoundException();
        return categoria;
    }

    public Categoria save(Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    public void delete(Categoria categoria){
        this.categoriaRepository.delete(categoria);
    }

}

package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Categoria;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity< List<Categoria> > findAll(){
        List<Categoria> categorias = this.categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = this.categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping()
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        categoria.setId(null);
        categoria = this.categoriaService.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria, @PathVariable Integer id){
        this.categoriaService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        categoria.setId(id);
        categoria = this.categoriaService.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Categoria categoria = this.categoriaService.findById(id);
        this.categoriaService.delete(categoria);
        return ResponseEntity.ok().body(null);
    }

}

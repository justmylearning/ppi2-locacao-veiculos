package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Avaria;
import com.ppi2.ppi2.v1.services.AvariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/avaria")
public class AvariaController {

    @Autowired
    private AvariaService avariaService;

    @GetMapping()
    public ResponseEntity< List<Avaria> > findAll(){
        List<Avaria> avarias = this.avariaService.findAll();
        return ResponseEntity.ok(avarias);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Avaria> findById(@PathVariable Integer id){
        Avaria avaria = this.avariaService.findById(id);
        return ResponseEntity.ok(avaria);
    }

    @PostMapping()
    public ResponseEntity<Avaria> create(@RequestBody Avaria avaria){
        avaria.setId(null);
        avaria = this.avariaService.save(avaria);
        return ResponseEntity.ok(avaria);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Avaria> save(@RequestBody Avaria avaria, @PathVariable Integer id){
        this.avariaService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        avaria.setId(id);
        avaria = this.avariaService.save(avaria);
        return ResponseEntity.ok(avaria);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Avaria avaria = this.avariaService.findById(id);
        this.avariaService.delete(avaria);
        return ResponseEntity.ok().body(null);
    }

}

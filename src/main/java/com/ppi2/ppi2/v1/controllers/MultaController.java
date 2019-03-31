package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Multa;
import com.ppi2.ppi2.v1.services.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/multa")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @GetMapping()
    public ResponseEntity< List<Multa> > findAll(){
        List<Multa> multas = this.multaService.findAll();
        return ResponseEntity.ok(multas);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Multa> findById(@PathVariable Integer id){
        Multa multa = this.multaService.findById(id);
        return ResponseEntity.ok(multa);
    }

    @PostMapping()
    public ResponseEntity<Multa> create(@RequestBody Multa multa){
        multa.setId(null);
        multa = this.multaService.save(multa);
        return ResponseEntity.ok(multa);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Multa> save(@RequestBody Multa multa, @PathVariable Integer id){
        this.multaService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        multa.setId(id);
        multa = this.multaService.save(multa);
        return ResponseEntity.ok(multa);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Multa multa = this.multaService.findById(id);
        this.multaService.delete(multa);
        return ResponseEntity.ok().body(null);
    }

}

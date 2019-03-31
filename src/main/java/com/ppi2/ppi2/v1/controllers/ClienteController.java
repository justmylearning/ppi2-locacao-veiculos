package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Cliente;
import com.ppi2.ppi2.v1.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity< List<Cliente> > findAll(){
        List<Cliente> clientes = this.clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = this.clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        cliente.setId(null);
        cliente = this.clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente, @PathVariable Integer id){
        this.clienteService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        cliente.setId(id);
        cliente = this.clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Cliente cliente = this.clienteService.findById(id);
        this.clienteService.delete(cliente);
        return ResponseEntity.ok().body(null);
    }

}

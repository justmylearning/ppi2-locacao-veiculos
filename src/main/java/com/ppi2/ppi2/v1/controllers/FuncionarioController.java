package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Funcionario;
import com.ppi2.ppi2.v1.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public ResponseEntity< List<Funcionario> > findAll(){
        List<Funcionario> funcionarios = this.funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
        Funcionario funcionario = this.funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping()
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        funcionario.setId(null);
        funcionario = this.funcionarioService.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario, @PathVariable Integer id){
        this.funcionarioService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        funcionario.setId(id);
        funcionario = this.funcionarioService.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Funcionario funcionario = this.funcionarioService.findById(id);
        this.funcionarioService.delete(funcionario);
        return ResponseEntity.ok().body(null);
    }

}

package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Avaria;
import com.ppi2.ppi2.v1.domain.Categoria;
import com.ppi2.ppi2.v1.domain.Locacao;
import com.ppi2.ppi2.v1.domain.Multa;
import com.ppi2.ppi2.v1.dto.LocacaoAvariaDTO;
import com.ppi2.ppi2.v1.dto.LocacaoDTO;
import com.ppi2.ppi2.v1.dto.LocacaoMultaDTO;
import com.ppi2.ppi2.v1.services.AvariaService;
import com.ppi2.ppi2.v1.services.CategoriaService;
import com.ppi2.ppi2.v1.services.LocacaoService;
import com.ppi2.ppi2.v1.services.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private AvariaService avariaService;
    @Autowired
    private MultaService multaService;

    @GetMapping()
    public ResponseEntity< List<Locacao> > findAll(){
        List<Locacao> locacoes = this.locacaoService.findAll();
        return ResponseEntity.ok(locacoes);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Locacao> findById(@PathVariable Integer id){
        Locacao locacao = this.locacaoService.findById(id);
        return ResponseEntity.ok(locacao);
    }

    @PostMapping()
    public ResponseEntity<Locacao> create(@RequestBody LocacaoDTO locacaoDTO){
        Locacao locacao = this.locacaoService.fromDTO(locacaoDTO);
        locacao = this.locacaoService.save(locacao);
        return ResponseEntity.ok(locacao);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Locacao> save(@RequestBody LocacaoDTO locacaoDTO, @PathVariable Integer id){
        this.locacaoService.findById(id); //Lança exceção caso locação não exista
        Locacao locacao = this.locacaoService.fromDTO(locacaoDTO);
        locacao.setId(id);
        locacao = this.locacaoService.save(locacao);
        return ResponseEntity.ok(locacao);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Locacao locacao = this.locacaoService.findById(id);
        this.locacaoService.delete(locacao);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("avaria")
    public ResponseEntity<Locacao> addAvaria(@RequestBody LocacaoAvariaDTO locacaoAvariaDTO){
        Locacao locacao = this.locacaoService.findById(locacaoAvariaDTO.getLocacaoId()); // Dispara exceção caso não exista
        Avaria avaria = this.avariaService.findById(locacaoAvariaDTO.getAvariaId());
        locacao.getAvarias().add(avaria);
        locacao = this.locacaoService.save(locacao);
        return ResponseEntity.ok().body(locacao);
    }

    @PutMapping("multa")
    public ResponseEntity<Locacao> addMulta(@RequestBody LocacaoMultaDTO locacaoMultaDTO){
        Locacao locacao = this.locacaoService.findById(locacaoMultaDTO.getLocacaoId()); // Dispara exceção caso não exista
        Multa multa = this.multaService.findById(locacaoMultaDTO.getMultaId());
        locacao.getMultas().add(multa);
        locacao = this.locacaoService.save(locacao);
        return ResponseEntity.ok().body(locacao);
    }

}
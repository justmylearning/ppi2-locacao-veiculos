package com.ppi2.ppi2.v1.controllers;

import com.ppi2.ppi2.v1.domain.Categoria;
import com.ppi2.ppi2.v1.domain.Veiculo;
import com.ppi2.ppi2.v1.dto.VeiculoDTO;
import com.ppi2.ppi2.v1.services.CategoriaService;
import com.ppi2.ppi2.v1.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity< List<Veiculo> > findAll(){
        List<Veiculo> veiculos = this.veiculoService.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Integer id){
        Veiculo veiculo = this.veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Veiculo> create(@RequestBody VeiculoDTO veiculoDTO){
        Categoria categoria = this.categoriaService.findById(veiculoDTO.getCategoriaId());
        Veiculo veiculo = new Veiculo(veiculoDTO.getMarca(), veiculoDTO.getModelo(), categoria);
        veiculo = this.veiculoService.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoDTO veiculoDTO, @PathVariable Integer id){
        Categoria categoria = this.categoriaService.findById(veiculoDTO.getCategoriaId());
        Veiculo veiculo = this.veiculoService.findById(id); //Verifica se o Objeto existe, senao lança exceção
        veiculo.setId(id);
        veiculo.setCategoria(categoria);
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo = this.veiculoService.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Veiculo veiculo = this.veiculoService.findById(id);
        this.veiculoService.delete(veiculo);
        return ResponseEntity.ok().body(null);
    }

}

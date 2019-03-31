package com.ppi2.ppi2.v1.services;

import com.ppi2.ppi2.v1.domain.Cliente;
import com.ppi2.ppi2.v1.domain.Funcionario;
import com.ppi2.ppi2.v1.domain.Locacao;
import com.ppi2.ppi2.v1.domain.Veiculo;
import com.ppi2.ppi2.v1.dto.LocacaoDTO;
import com.ppi2.ppi2.v1.exceptions.ObjectNotFoundException;
import com.ppi2.ppi2.v1.repositories.ClienteRepository;
import com.ppi2.ppi2.v1.repositories.FuncionarioRepository;
import com.ppi2.ppi2.v1.repositories.LocacaoRepository;
import com.ppi2.ppi2.v1.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private FuncionarioService funcionarioService;

    public List<Locacao> findAll(){
        return this.locacaoRepository.findAll();
    }

    public Locacao findById(Integer id){
        Locacao locacao = this.locacaoRepository.findById(id).orElse(null);
        if(locacao == null)
            throw new ObjectNotFoundException();
        return locacao;
    }

    public Locacao save(Locacao locacao){
        return this.locacaoRepository.save(locacao);
    }

    public void delete(Locacao locacao){
        this.locacaoRepository.delete(locacao);
    }

    public Locacao fromDTO(LocacaoDTO locacaoDTO){
        Cliente cliente = this.clienteService.findById(locacaoDTO.getClienteId());
        Veiculo veiculo = this.veiculoService.findById(locacaoDTO.getVeiculoId());
        Funcionario funcionarioCad = this.funcionarioService.findById(locacaoDTO.getFuncionarioCadId());
        Locacao locacao = new Locacao(veiculo, cliente, funcionarioCad);
        if(locacaoDTO.getFuncionarioRecId() != null){
            Funcionario funcionarioRec = this.funcionarioService.findById(locacaoDTO.getFuncionarioRecId());
            locacao.setFuncionario_rec(funcionarioRec);
        }

        return locacao;

    }

}

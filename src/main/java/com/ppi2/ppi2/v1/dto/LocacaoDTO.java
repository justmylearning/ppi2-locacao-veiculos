package com.ppi2.ppi2.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ppi2.ppi2.v1.domain.Avaria;
import com.ppi2.ppi2.v1.domain.Multa;

import javax.persistence.OneToMany;
import java.util.List;

public class LocacaoDTO {
    @JsonProperty("veiculo_id")
    private Integer veiculoId;
    @JsonProperty("cliente_id")
    private Integer clienteId;
    @JsonProperty("funcionario_cad_id")
    private Integer funcionarioCadId;
    @JsonProperty("funcionario_rec_id")
    private Integer funcionarioRecId;
    @OneToMany
    private List<Multa> multas;
    @OneToMany
    private List<Avaria> avarias;

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getFuncionarioCadId() {
        return funcionarioCadId;
    }

    public void setFuncionarioCadId(Integer funcionarioCadId) {
        this.funcionarioCadId = funcionarioCadId;
    }

    public Integer getFuncionarioRecId() {
        return funcionarioRecId;
    }

    public void setFuncionarioRecId(Integer funcionarioRecId) {
        this.funcionarioRecId = funcionarioRecId;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }

    public List<Avaria> getAvarias() {
        return avarias;
    }

    public void setAvarias(List<Avaria> avarias) {
        this.avarias = avarias;
    }
}
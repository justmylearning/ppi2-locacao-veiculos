package com.ppi2.ppi2.v1.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario_cad;
    @ManyToOne
    private Funcionario funcionario_rec;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Multa> multas;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Avaria> avarias;

    public Locacao() {
    }

    public Locacao(Veiculo veiculo, Cliente cliente, Funcionario funcionario_cad) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.funcionario_cad = funcionario_cad;
    }

    public Locacao(Veiculo veiculo, Cliente cliente, Funcionario funcionario_cad, Funcionario funcionario_rec) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.funcionario_cad = funcionario_cad;
        this.funcionario_rec = funcionario_rec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario_cad() {
        return funcionario_cad;
    }

    public void setFuncionario_cad(Funcionario funcionario_cad) {
        this.funcionario_cad = funcionario_cad;
    }

    public Funcionario getFuncionario_rec() {
        return funcionario_rec;
    }

    public void setFuncionario_rec(Funcionario funcionario_rec) {
        this.funcionario_rec = funcionario_rec;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacao categoria = (Locacao) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

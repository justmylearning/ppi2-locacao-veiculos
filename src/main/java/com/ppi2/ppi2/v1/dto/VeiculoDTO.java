package com.ppi2.ppi2.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoDTO {
    @JsonProperty("categoria_id")
    private Integer categoriaId;
    private String marca;
    private String modelo;

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

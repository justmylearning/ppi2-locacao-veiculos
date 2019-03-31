package com.ppi2.ppi2.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocacaoAvariaDTO {
    @JsonProperty("locacao_id")
    private Integer locacaoId;
    @JsonProperty("avaria_id")
    private Integer avariaId;

    public Integer getLocacaoId() {
        return locacaoId;
    }

    public void setLocacaoId(Integer locacaoId) {
        this.locacaoId = locacaoId;
    }

    public Integer getAvariaId() {
        return avariaId;
    }

    public void setAvariaId(Integer avariaId) {
        this.avariaId = avariaId;
    }
}

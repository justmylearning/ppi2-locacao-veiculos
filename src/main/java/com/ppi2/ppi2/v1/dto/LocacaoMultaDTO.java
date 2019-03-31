package com.ppi2.ppi2.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocacaoMultaDTO {
    @JsonProperty("locacao_id")
    private Integer locacaoId;
    @JsonProperty("multa_id")
    private Integer multaId;

    public Integer getLocacaoId() {
        return locacaoId;
    }

    public void setLocacaoId(Integer locacaoId) {
        this.locacaoId = locacaoId;
    }

    public Integer getMultaId() {
        return multaId;
    }

    public void setMultaId(Integer multaId) {
        this.multaId = multaId;
    }
}

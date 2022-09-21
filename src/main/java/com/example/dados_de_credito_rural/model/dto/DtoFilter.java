package com.example.dados_de_credito_rural.model.dto;

import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DtoFilter implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String municipio;
    private String nomeProduto;
    private String cdMunicipio;
    private String cdProduto;
    @JsonProperty("AnoEmissao")
    private String anoEmissao;
    @JsonProperty("AreaInvest")
    private double areaInvest;

    public DtoFilter(InvestMunicipio investMunicipio) {
        id = investMunicipio.getId();
        municipio = investMunicipio.getMunicipio();
        nomeProduto = investMunicipio.getNomeProduto();
        cdMunicipio = investMunicipio.getCdMunicipio();
        cdProduto = investMunicipio.getCdProduto();
        anoEmissao = investMunicipio.getAnoEmissao();
        areaInvest = investMunicipio.getAreaInvest();
    }
}


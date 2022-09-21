package com.example.dados_de_credito_rural.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.io.Serializable;

//@JsonRootName: anotação para renomear o nome da raiz do objeto JSON
//value: nome da raiz do objeto JSON
@JsonRootName(value = "value")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class InvestMunicipiosList implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Municipio")
    private String municipio;
    private String nomeProduto;
    @JsonProperty("MesEmissao")
    private String mesEmissao;
    @JsonProperty("AnoEmissao")
    private String anoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private String cdEstado;
    @JsonProperty("VlCusteio")
    private double vlCusteio;
    private String cdProduto;
    private String cdMunicipio;
    @JsonProperty("Atividade")
    private String atividade;
    private String cdModalidade;
    @JsonProperty("AreaInvest")
    private double areaInvest;
}

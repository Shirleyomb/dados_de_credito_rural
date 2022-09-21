package com.example.dados_de_credito_rural.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoValue {
    @JsonProperty("Municipio")
    public String municipio;
    public String nomeProduto;
    @JsonProperty("MesEmissao")
    public String mesEmissao;
    @JsonProperty("AnoEmissao")
    public String anoEmissao;
    public String cdPrograma;
    public String cdSubPrograma;
    public String cdFonteRecurso;
    public String cdTipoSeguro;
    public String cdEstado;
    @JsonProperty("VlCusteio")
    public double vlCusteio;
    public String cdProduto;
    public String cdMunicipio;
    @JsonProperty("Atividade")
    public String atividade;
    public String cdModalidade;
    @JsonProperty("AreaInvest")
    public double areaInvest;
}

package com.example.dados_de_credito_rural.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Investimento")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InvestMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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



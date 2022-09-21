package com.example.dados_de_credito_rural.model.entities.converter;

import com.example.dados_de_credito_rural.model.dto.InvestMunicipiosList;
import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;

// DataConverter: conversor de dados
// Conversor de dados: converte dados de um formato para outro
// Convertendo os dados do formato DTO para o formato Entity
public class DataConverter {
    public static InvestMunicipio getEntity(InvestMunicipiosList dto) {
        return InvestMunicipio.builder()
                .municipio(dto.getMunicipio())
                .nomeProduto(dto.getNomeProduto())
                .mesEmissao(dto.getMesEmissao())
                .anoEmissao(dto.getAnoEmissao())
                .cdPrograma(dto.getCdPrograma())
                .cdSubPrograma(dto.getCdSubPrograma())
                .cdFonteRecurso(dto.getCdFonteRecurso())
                .cdTipoSeguro(dto.getCdTipoSeguro())
                .cdEstado(dto.getCdEstado())
                .cdMunicipio(dto.getCdMunicipio())
                .cdProduto(dto.getCdProduto())
                .vlCusteio(dto.getVlCusteio())
                .atividade(dto.getAtividade())
                .cdModalidade(dto.getCdModalidade())
                .areaInvest(dto.getAreaInvest())
                .build();
    }
}

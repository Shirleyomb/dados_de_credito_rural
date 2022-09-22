package com.example.dados_de_credito_rural.repositorios;

import com.example.dados_de_credito_rural.model.entities.converter.DtoFilterConverter;
import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestMunicipioRepository extends JpaRepository<InvestMunicipio, Long> {

    @Query("SELECT obj FROM InvestMunicipio obj WHERE LOWER(obj.anoEmissao) LIKE LOWER(CONCAT('%',:anoEmissao,'%'))")
    Page<InvestMunicipio> searchAno(String anoEmissao, Pageable pageable);

    @Query(value = "SELECT obj.anoEmissao as anoEmissao, " +
            "obj.municipio as municipio, " +
            "obj.nomeProduto as nomeProduto, " +
            "obj.cdMunicipio as cdMunicipio, " +
            "SUM(obj.areaInvest) as areaInvestSum " +
            "FROM InvestMunicipio obj " +
            "WHERE obj.anoEmissao = :anoEmissao AND obj.cdProduto IN ('7100', '6720', '3560', '5080', '1840') " +
            "GROUP BY obj.anoEmissao, obj.municipio, obj.nomeProduto")
    List<DtoFilterConverter> searchYearFilter(String anoEmissao);
}




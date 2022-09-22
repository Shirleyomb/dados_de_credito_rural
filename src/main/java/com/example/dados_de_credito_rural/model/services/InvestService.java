package com.example.dados_de_credito_rural.model.services;

import com.example.dados_de_credito_rural.model.dto.DtoFilter;
import com.example.dados_de_credito_rural.model.entities.converter.DtoFilterConverter;
import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;
import com.example.dados_de_credito_rural.model.services.exceptions.ResourceNotFoundException;
import com.example.dados_de_credito_rural.repositorios.InvestMunicipioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InvestService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvestMunicipioRepository investMunicipioRepository;

    public Page<InvestMunicipio> listaInvest(Pageable pageable) {
        return investMunicipioRepository.findAll(pageable);
    }

    public InvestMunicipio save(InvestMunicipio investMunicipio) {
        return investMunicipioRepository.save(investMunicipio);
    }

    public void AddNew(InvestMunicipio investMunicipio) {
        investMunicipioRepository.save(investMunicipio);
    }

    public Optional<InvestMunicipio> findById(long id) {
        return investMunicipioRepository.findById(id);
    }

    public InvestMunicipio findByIdd(Long id) {
        Optional<InvestMunicipio> obj = investMunicipioRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        try {
            investMunicipioRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Page<InvestMunicipio> findAll(Pageable pageable) {
        return investMunicipioRepository.findAll(pageable);
    }

    public Page<InvestMunicipio> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return investMunicipioRepository.findAll(pageable);
    }

    //Filtro Completo por Municipio agrupado por produto com soma dos itens
    public List<DtoFilterConverter> findFilter(String anoEmissao) {
        return investMunicipioRepository.searchYearFilter(anoEmissao);
    }

    public void update(InvestMunicipio investMunicipio) {
        investMunicipioRepository.save(investMunicipio);
    }

    public DtoFilter toDtoFilter(InvestMunicipio investMunicipio) {
        return modelMapper.map(investMunicipio, DtoFilter.class);
    }

    public List<DtoFilter> listAll(String anoEmissao, Pageable pageable) {
        return investMunicipioRepository.searchAno(anoEmissao, pageable)
                .stream()
                .map(this::toDtoFilter)
                .collect(Collectors.toList());
    }

    public Page<InvestMunicipio> searchByAno(String anoEmissao, Pageable pageable) {
        Page<InvestMunicipio> result = investMunicipioRepository.searchAno(anoEmissao, pageable);
        return result;
    }

    public void updateList(InvestMunicipio investMunicipio) {
        investMunicipioRepository.findById(investMunicipio.getId())
                .map(InvestMunicipio -> {
                    modelMapper.map(investMunicipio, InvestMunicipio);
                    investMunicipioRepository.save(investMunicipio);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado nao encontrado."));
    }

    public void saveAll(InvestMunicipio investMunicipio) {
        investMunicipioRepository.save(investMunicipio);
    }

    public void deletarPorId(Long id) {
        investMunicipioRepository.deleteById(id);
    }

    public InvestMunicipio salvar(InvestMunicipio investMunicipio) {
        return investMunicipioRepository.save(investMunicipio);
    }
}


package com.example.dados_de_credito_rural.controller;


import com.example.dados_de_credito_rural.client.FeignClienteInvest;
import com.example.dados_de_credito_rural.model.dto.DtoFilter;
import com.example.dados_de_credito_rural.model.dto.DtoRoot;
import com.example.dados_de_credito_rural.model.dto.InvestMunicipiosList;
import com.example.dados_de_credito_rural.model.entities.converter.DtoFilterConverter;
import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;
import com.example.dados_de_credito_rural.model.entities.converter.DataConverter;
import com.example.dados_de_credito_rural.model.services.InvestService;
import com.example.dados_de_credito_rural.repositorios.InvestMunicipioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/posts")
@Api(value = "API REST Investimentos e Produtos por Municipio")
@CrossOrigin(origins = "*")
public class InvestControllerHttp {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvestMunicipioRepository investMunicipioRepository;

    @Autowired
    public InvestService investService;

    private FeignClienteInvest feignClienteInvest;

    //Dados recebidos da API
    @PostConstruct
    public DtoRoot getallPosts() {
        DtoRoot root = feignClienteInvest.getAllPosts();

        for (InvestMunicipiosList p : root.getValue()) {
            InvestMunicipio investMunicipio = DataConverter.getEntity(p);
            investService.saveAll(investMunicipio);
        }
        return root;
    }

    //Retorna lista de produtos paginada
    @GetMapping
    @ApiOperation(value = "Retorna uma lista de produtos - Inserir parametros")
    @ResponseStatus(HttpStatus.OK)
    public Page<InvestMunicipio> listaInvest(Pageable pageable) {
        return investService.listaInvest(pageable);
    }

    //END POINT - Retorna lista de produtos paginada para a View HTML
    @GetMapping("/pages")
    @ApiOperation(value = "Retorna uma lista de produtos com paginação")
    public ModelAndView getList(Model model, Pageable pageable) {
        Page<InvestMunicipio> listaInvest = this.investService.findAll(pageable);

        ModelAndView mv = new ModelAndView("dashBoard");
        mv.addObject("listaInvest", listaInvest);
        return mv;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adicionar novo registro")
    public InvestMunicipio save(@RequestBody InvestMunicipio investMunicipio) {
        return investService.salvar(investMunicipio);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retorna um único registro por ID")
    @ResponseStatus(HttpStatus.OK)
    public InvestMunicipio findByIdd(@PathVariable("id") Long id) {
        return investService.findByIdd(id);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deleta um único registro por ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        investService.findById(id)
                .map(investMunicipio -> {
                    investService.deletarPorId(id);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found, id " + id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza registro da lista")
    public void updateList(@PathVariable("id") Long id, @RequestBody InvestMunicipio investMunicipio) {
        investMunicipio.setId(id);
        investService.updateList(investMunicipio);
    }

    @GetMapping(value = "/search-year")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna lista de produtos por ano")
    public ResponseEntity<Page<InvestMunicipio>> searchByAno(
            @RequestParam(defaultValue = "") String anoEmissao,
            Pageable pageable) {
        Page<InvestMunicipio> list = investService.searchByAno(anoEmissao, pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/search-filter")
    @ApiOperation(value = "EndPoint HTML")
    public ModelAndView getListFilter(@RequestParam String anoEmissao, Pageable pageable) {
        List<DtoFilter> list = investService.listAll(anoEmissao, Pageable.unpaged());

        ModelAndView mv = new ModelAndView("dashBoardFilter");
        mv.addObject("list", list);
        return mv;
    }
}


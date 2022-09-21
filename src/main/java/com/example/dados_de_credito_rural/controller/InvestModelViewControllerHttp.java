package com.example.dados_de_credito_rural.controller;

import com.example.dados_de_credito_rural.model.entities.InvestMunicipio;
import com.example.dados_de_credito_rural.model.services.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

public class InvestModelViewControllerHttp {

    @Autowired
    private InvestService investService;

    @RequestMapping("/getAll")
    public String getAll(Model model, Pageable pageable) {
        Page<InvestMunicipio> investimento = investService.findAll(pageable);
        model.addAttribute("investimento", investimento);


        String username = "Shirley";
        model.addAttribute("username", username);

        return "investimento";
    }

    @RequestMapping("/id")
    @ResponseBody
    public Optional<InvestMunicipio> findById(Long id) {
        return investService.findById(id);
    }

    @PostMapping("/addNew")
    public String addNew(InvestMunicipio investMunicipio) {
        investService.AddNew(investMunicipio);
        return "redirect:/investimento/getAll";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvestMunicipio investMunicipio) {
        investService.update(investMunicipio);
        return "redirect:/investimento/getAll";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        investService.deleteById(id);
        return "redirect:/investimento/getAll";
    }
}



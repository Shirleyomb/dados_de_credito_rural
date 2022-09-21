package com.example.dados_de_credito_rural.client;

import com.example.dados_de_credito_rural.model.dto.DtoRoot;
//import com.example.dados_de_credito_rural.model.dto.InvestMunicipiosList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



    //https://dadosabertos.bcb.gov.br/dataset/matrizdadoscreditorural
    //@FeignClient: é uma anotação que habilita o suporte para o Feign.
    //Feign é um cliente HTTP declarativo, que permite que você crie facilmente um cliente HTTP para consumir serviços REST.

    //FeingClient: é uma anotação que habilita o suporte para o Feign.
    @FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/InvestMunicipioProduto?%24format=json&%24top=100")
    public interface

    FeignClienteInvest {

        //GetMapping: é uma anotação que mapeia solicitações HTTP GET em métodos de manipulador específicos.
        //value: é um atributo da anotação GetMapping.
        //getAllPosts: é um método que retorna um objeto do tipo DtoRoot.
        //DtoRoot: é uma classe que representa o objeto raiz do JSON.
        @GetMapping(value = "")
        DtoRoot getAllPosts();
    }



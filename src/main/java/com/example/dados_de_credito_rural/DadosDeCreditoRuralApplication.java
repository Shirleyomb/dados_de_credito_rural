package com.example.dados_de_credito_rural;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//EnableWebMvc: é uma anotação que habilita o suporte para o Spring MVC.
//EnableFeignClients: é uma anotação que habilita o suporte para o Feign.
//Feign é um cliente HTTP declarativo, que permite que você crie facilmente um cliente HTTP para consumir serviços REST.
//SpringBootApplication: é uma anotação que habilita o suporte para o Spring Boot.
@EnableWebMvc
@EnableFeignClients
@SpringBootApplication
public class DadosDeCreditoRuralApplication {

    public static void main(String[] args) {
        SpringApplication.run(DadosDeCreditoRuralApplication.class, args);
    }

}

package com.br.fiap.postech.soat7grupo5_pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = 
@Info(title = "Soat7grupo5 API - Pedidos", 
	version = "1.0", 
	description = "Página de referência da Soat7grupo5 API - Pedidos")
)
public class Soat7grupo5PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Soat7grupo5PedidoApplication.class, args);
	}

}

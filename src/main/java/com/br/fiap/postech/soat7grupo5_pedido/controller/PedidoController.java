package com.br.fiap.postech.soat7grupo5_pedido.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pedidos", description = "Recursos relacionados aos pedidos.")
@RequestMapping(path="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	@PostMapping(path="/registrar")
	@Operation(summary = "Registrar pedido.")
	String criarPedido() {
		return null;
	}
	
	@GetMapping(path="/buscar-infos-necessarias")
	@Operation(summary = "Retorna informações necessárias para montar pedidos.")
	String buscarInfosNecessarias() {
		return null;
	}
	
	@GetMapping
	@Operation(summary = "Retorna lista com todos os pedidos registrados.")
	String buscarPedidosRegistrados() {
		return null;
	}
	
	@GetMapping(path="/buscar-pedidos-cliente")
	@Operation(summary = "Retorna lista com pedidos em produção(visão cliente).")
	String buscarPedidosProducaoCliente() {
		return null;
	}
}

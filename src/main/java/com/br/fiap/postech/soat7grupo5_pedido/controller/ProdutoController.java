package com.br.fiap.postech.soat7grupo5_pedido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5_pedido.dto.ProdutoDto;
import com.br.fiap.postech.soat7grupo5_pedido.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produtos", description = "Recursos relacionados aos produtos.")
@RequestMapping(path="produtos", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(path="/buscar-produtos-por-tipo/{idTipo}")
	@Operation(summary = "Retorna lista com produtos de um determinado tipo.")
	ResponseEntity<?> buscarProdutoPorCategoria(@Parameter(description = "ID do tipo", example = "1") @PathVariable int idTipo) {
		List<ProdutoDto> listaProdutoDto = new ArrayList<ProdutoDto>(); 
		listaProdutoDto = produtoService.buscarProdutosPorCategoria(idTipo);
		return new ResponseEntity<>(listaProdutoDto, HttpStatus.OK);
	}
	
}

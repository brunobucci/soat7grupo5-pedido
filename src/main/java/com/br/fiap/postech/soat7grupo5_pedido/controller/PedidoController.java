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
	
	
//	@PutMapping(path="{idPedido}/status/{idStatus}")
//	@Operation(summary = "Realiza a edição do pedido.")
//	PedidoResponse editarPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Recebido, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
//		Pedido pedido = editarPedidoInteractor.editarPedido(idPedido, idStatus);
//		return pedidoDTOMapper.toResponse(pedido);
//	}
//
//	@GetMapping
//	@Operation(summary = "Retorna lista com todos os pedidos cadastrados.")
//	List<PedidoCompletoResponse> buscarPedidos() {
//		List<PedidoCompletoResponse> pedidosCompletosResponse = new ArrayList<PedidoCompletoResponse>(); 
//		List<Pedido> pedidos = buscarPedidosInteractor.buscarPedidos();
//		for(Pedido pedido : pedidos){
//			PedidoCompletoResponse pedidoCompletoResponse = new PedidoCompletoResponse();
//			pedidoCompletoResponse.setPedido(pedido);
//			List<PedidoProduto> pedidoProdutosPedido = buscarPedidoProdutoPorIdPedidoInteractor.buscarPedidoProdutosPorIdPedido(pedido.getIdPedido());
//			pedidoCompletoResponse.setPedidoProdutos(pedidoProdutosPedido);
//			pedidosCompletosResponse.add(pedidoCompletoResponse);
//		}	
//		return pedidosCompletosResponse;
//	}

//	@GetMapping(path="/busca-ordenada")
//	@Operation(summary = "Retorna lista com pedidos ordenados.")
//	List<PedidoCompletoResponse> buscarPedidosOrdenados() {
//		List<PedidoCompletoResponse> pedidosCompletosResponse = new ArrayList<PedidoCompletoResponse>();
//		List<Pedido> pedidos = buscarPedidosOrdenadosInteractor.buscarPedidosOrdenados();
//		for(Pedido pedido : pedidos){
//			PedidoCompletoResponse pedidoCompletoResponse = new PedidoCompletoResponse();
//			pedidoCompletoResponse.setPedido(pedido);
//			pedidoCompletoResponse.setPedidoProdutos(buscarPedidoProdutoPorIdPedidoInteractor.buscarPedidoProdutosPorIdPedido(pedido.getIdPedido()));
//			pedidosCompletosResponse.add(pedidoCompletoResponse);
//		}	
//		return pedidosCompletosResponse;
//	}

//	@GetMapping(path="/status-pagamento/{idPedido}")
//	@Operation(summary = "Buscar status pagamento por id do pedido.")
//	String buscarStatusPagamentoPedidoPorId(@Parameter(description = "ID do pedido", example = "1") @PathVariable int idPedido) {
//		boolean pagamentAprovado = buscarStatusPagamentoPedidoPorIdInteractor.buscarStatusPagamentoPedidoPorId(idPedido);
//		return "{ \"pagamentoAprovado\" : " + pagamentAprovado + " }";
//	}    
//
//	@GetMapping(path="/{idStatus}")
//	@Operation(summary = "Busca pedidos por status.")
//	List<PedidoResponse> buscarPedidosPorStatus(@Parameter(description = "ID do status", example = "1") @PathVariable int idStatus) {
//		List<Pedido> pedidos = buscarPedidosPorStatusInteractor.buscarPedidosPorStatus(idStatus);
//		return pedidoDTOMapper.toResponseList(pedidos);
//	}
}

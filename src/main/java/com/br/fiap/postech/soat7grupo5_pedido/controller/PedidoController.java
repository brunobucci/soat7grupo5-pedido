package com.br.fiap.postech.soat7grupo5_pedido.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoCompletoDto;
import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoDto;
import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoProdutoDto;
import com.br.fiap.postech.soat7grupo5_pedido.service.PedidoProdutoService;
import com.br.fiap.postech.soat7grupo5_pedido.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pedidos", description = "Recursos relacionados aos pedidos.")
@RequestMapping(path="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PedidoProdutoService pedidoProdutoService;
	
	@PostMapping(path="/registrar")
	@Operation(summary = "Registrar pedido.")
	ResponseEntity<?>  registrarPedido(@RequestBody PedidoCompletoDto pedidoCompletoDto) {
		Double precoTotal = pedidoCompletoDto.getPedidoProdutoDtos().stream().collect(Collectors.summingDouble(PedidoProdutoDto::getPrecoProduto));
		int duracaoTotal = pedidoCompletoDto.getPedidoProdutoDtos().stream().collect(Collectors.summingInt(PedidoProdutoDto::getDuracaoPreparo));
		pedidoCompletoDto.getPedidoDto().setPreco(precoTotal);
		pedidoCompletoDto.getPedidoDto().setDuracaoTotalPreparo(duracaoTotal);
		PedidoDto pedidoDto = pedidoService.salvarPedido(pedidoCompletoDto.getPedidoDto());
		pedidoProdutoService.salvarPedidoProduto(pedidoDto.getIdPedido(), pedidoCompletoDto.getPedidoProdutoDtos());
		
		return new ResponseEntity<>(pedidoDto, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/inicia-solicitacao-pagamento")
	@Operation(summary = "Inicia uma solicitação de pagamento na API Pagamentos")
	String iniciarSolicitacaoPagamento() {
		return null;
	}
	
	@GetMapping
	@Operation(summary = "Retorna lista com todos os pedidos registrados.")
	ResponseEntity<?> buscarPedidosRegistrados() {
		List<PedidoCompletoDto> listaPedidoCompletosDto = new ArrayList<PedidoCompletoDto>(); 
		List<PedidoDto> listaPedidosDto = pedidoService.buscarPedidos();
		for(PedidoDto pedidoDto : listaPedidosDto) {
			PedidoCompletoDto pedidoCompletoDto = new PedidoCompletoDto();
			pedidoCompletoDto.setPedidoDTO(pedidoDto);
			pedidoCompletoDto.setPedidoProdutoDTOs(pedidoProdutoService.buscarPedidoProdutosPorIdPedido(pedidoDto.getIdPedido()));
			listaPedidoCompletosDto.add(pedidoCompletoDto);
		}
		return new ResponseEntity<>(listaPedidoCompletosDto, HttpStatus.OK);
	}
	
	@GetMapping(path="/buscar-pedidos-visao-cliente/{idCliente}")
	@Operation(summary = "Retorna lista com pedidos em produção (visão cliente).")
	ResponseEntity<?> buscarPedidosProducaoCliente(@Parameter(description = "ID do cliente", example = "1") @PathVariable int idCliente) {
		List<PedidoCompletoDto> listaPedidoCompletosDto = new ArrayList<PedidoCompletoDto>(); 
		List<PedidoDto> listaPedidosDto = pedidoService.buscarPedidosPorCliente(idCliente);
		for(PedidoDto pedidoDto : listaPedidosDto) {
			PedidoCompletoDto pedidoCompletoDto = new PedidoCompletoDto();
			pedidoCompletoDto.setPedidoDTO(pedidoDto);
			pedidoCompletoDto.setPedidoProdutoDTOs(pedidoProdutoService.buscarPedidoProdutosPorIdPedido(pedidoDto.getIdPedido()));
			listaPedidoCompletosDto.add(pedidoCompletoDto);
		}
		return new ResponseEntity<>(listaPedidoCompletosDto, HttpStatus.OK);
	}
	
	@PutMapping(path="{idPedido}/status/{idStatus}")
	@Operation(summary = "Realiza a atualização do status do pedido.")
	void atualizarStatusPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Pendente Pagamento, 2: Em preparo, 3: Nova Tentativa de pgto., 4:Pronto, 5: Finalizado, 6:Cancelado).", example = "1") @PathVariable int idStatus) {
		PedidoDto pedidoDto = new PedidoDto(idPedido, idStatus);
		pedidoService.salvarPedido(pedidoDto);
	}
	
	@PutMapping(path="{idPedido}/status-pagamento/{idStatusPagamento}")
	@Operation(summary = "Realiza a atualização do status do pagamento do pedido.")
	void atualizarStatusPagamentoPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pgto. do pedido (0: Pendente Pagamento, 1: Aprovado, 2: Reprovado).", example = "1") @PathVariable int idStatusPagamento) {
		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setIdPedido(idPedido);
		pedidoDto.setIdStatusPagamento(idStatusPagamento);
		pedidoService.salvarPedido(pedidoDto);
	}
}

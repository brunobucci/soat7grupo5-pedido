package com.br.fiap.postech.soat7grupo5_pedido.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoProdutoDto;
import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoProdutoEntity;
import com.br.fiap.postech.soat7grupo5_pedido.repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {

	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	public List<PedidoProdutoDto> buscarPedidoProdutos() {
		List<PedidoProdutoEntity> pedidoProdutos = pedidoProdutoRepository.findAll();
		List<PedidoProdutoDto> produtoDTOS = pedidoProdutos.stream().map(PedidoProdutoEntity::toPedidoProdutoDto).collect(Collectors.toList());
		return produtoDTOS;
	}

	public void salvarPedidoProduto(int idPedido, List<PedidoProdutoDto> PedidoProdutoDtos) {
		List<PedidoProdutoEntity> pedidoProdutosEntity = new ArrayList<PedidoProdutoEntity>();
		for(PedidoProdutoDto PedidoProdutoDto : PedidoProdutoDtos) {
			PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity(PedidoProdutoDto);
			pedidoProdutoEntity.setIdPedido(idPedido);
			pedidoProdutosEntity.add(pedidoProdutoEntity);			
		}
		pedidoProdutoRepository.saveAll(pedidoProdutosEntity);
	}

	public List<PedidoProdutoDto> buscarPedidoProdutosPorIdPedido(int idPedido) {
		List<PedidoProdutoEntity> pedidoProdutos = pedidoProdutoRepository.findByIdPedido(idPedido);
		List<PedidoProdutoDto> PedidoProdutoDtos = pedidoProdutos.stream().map(PedidoProdutoEntity::toPedidoProdutoDto).collect(Collectors.toList());
		return PedidoProdutoDtos;
	}
}

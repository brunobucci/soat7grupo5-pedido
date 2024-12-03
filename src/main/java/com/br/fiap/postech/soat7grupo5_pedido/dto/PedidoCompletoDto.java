package com.br.fiap.postech.soat7grupo5_pedido.dto;

import java.util.List;

public class PedidoCompletoDto {

	private PedidoDto pedidoDto;
	private List<PedidoProdutoDto> pedidoProdutoDtos;
	

	public PedidoDto getPedidoDto() {
		return pedidoDto;
	}
	public void setPedidoDTO(PedidoDto pedidoDto) {
		this.pedidoDto = pedidoDto;
	}
	public List<PedidoProdutoDto> getPedidoProdutoDtos() {
		return pedidoProdutoDtos;
	}
	public void setPedidoProdutoDTOs(List<PedidoProdutoDto> pedidoProdutoDtos) {
		this.pedidoProdutoDtos = pedidoProdutoDtos;
	}
}

package com.br.fiap.postech.soat7grupo5_pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoApiDto {
	private int id;
	private int idPedido;
	private int idPagamento;
	private int idStatusPagamento;
}
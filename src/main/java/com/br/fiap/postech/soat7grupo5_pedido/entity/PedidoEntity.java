package com.br.fiap.postech.soat7grupo5_pedido.entity;

import java.util.Date;
import java.util.Objects;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedido;
	private Double preco;
	private int idStatus;
	private int idCliente;
	private int idPagamento;
	private int idStatusPagamento;
	private int duracaoTotalPreparo;
	private Date dataCriacao;
	
	public PedidoEntity() {
	}
	
	public PedidoEntity(PedidoDto pedido) {
		this.idPedido = pedido.getIdPedido();
		this.preco = pedido.getPreco();
		this.idStatus = pedido.getIdStatus();
		this.idCliente = pedido.getIdCliente();
		this.idPagamento = pedido.getIdPagamento();
		this.idStatusPagamento = pedido.getIdStatusPagamento();
		this.duracaoTotalPreparo = pedido.getDuracaoTotalPreparo();
		this.dataCriacao = pedido.getDataCriacao();
	}
	
	public void atualizar(PedidoDto pedido) {
		this.preco = Objects.nonNull(pedido.getPreco()) ? pedido.getPreco() : this.preco;
		this.idStatus = (pedido.getIdStatus() != 0) ? pedido.getIdStatus() : this.idStatus;
		this.idCliente = (pedido.getIdCliente() != 0) ? pedido.getIdCliente() : this.idCliente;
		this.idPagamento = (pedido.getIdPagamento() != 0) ? pedido.getIdPagamento() : this.idPagamento;
		this.idStatusPagamento = (pedido.getIdStatusPagamento() != 0) ? pedido.getIdStatusPagamento() : this.idStatusPagamento;
		this.duracaoTotalPreparo = (pedido.getDuracaoTotalPreparo() != 0) ? pedido.getDuracaoTotalPreparo() : this.duracaoTotalPreparo;
	}
	
	public PedidoDto toPedidoDto() {
		return new PedidoDto(this.idPedido, this.preco, this.idStatus, this.idCliente, this.idPagamento,this.idStatusPagamento, this.duracaoTotalPreparo, this.dataCriacao);
	}
}
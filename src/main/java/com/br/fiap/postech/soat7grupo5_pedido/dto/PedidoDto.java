package com.br.fiap.postech.soat7grupo5_pedido.dto;

import java.util.Date;


public class PedidoDto {

	private int idPedido;
	private Double preco;
	private int idStatus;
	private int idCliente;
	private int idPagamento;
	private int idStatusPagamento;
	private int duracaoTotalPreparo;
	private Date dataCriacao;
	
	public PedidoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PedidoDto(int idPedido, Double preco, int idStatus, int idCliente, int idPagamento, int idStatusPagamento, int duracaoTotalPreparo, Date dataCriacao) {
		this.idPedido = idPedido;
		this.preco = preco;
		this.idStatus = idStatus;
		this.idCliente = idCliente;
		this.idPagamento = idPagamento;
		this.idStatusPagamento = idStatusPagamento;
		this.duracaoTotalPreparo = duracaoTotalPreparo;
		this.dataCriacao = dataCriacao;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public int getDuracaoTotalPreparo() {
		return duracaoTotalPreparo;
	}

	public void setDuracaoTotalPreparo(int duracaoTotalPreparo) {
		this.duracaoTotalPreparo = duracaoTotalPreparo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getIdStatusPagamento() {
		return idStatusPagamento;
	}

	public void setIdStatusPagamento(int idStatusPagamento) {
		this.idStatusPagamento = idStatusPagamento;
	}

	public PedidoDto(PedidoDto pedidoDTO) {
		this.idPedido = pedidoDTO.getIdPedido();
		this.preco = pedidoDTO.getPreco();
		this.idStatus = pedidoDTO.getIdStatus();
		this.idCliente = pedidoDTO.getIdCliente();
		this.idPagamento = pedidoDTO.getIdPagamento();
		this.idStatusPagamento = pedidoDTO.getIdStatusPagamento();
		this.duracaoTotalPreparo = pedidoDTO.getDuracaoTotalPreparo();
		this.dataCriacao = pedidoDTO.getDataCriacao();
    }

    public PedidoDto(int idPedido2, int idStatus2) {
    	this.idPedido = idPedido2;
		this.idStatus = idStatus2;
	}
    
	public PedidoDto toPedidoDto() {
        return new PedidoDto(this.idPedido, this.preco, this.idStatus, this.idCliente, this.idPagamento, this.idStatusPagamento, this.duracaoTotalPreparo, this.dataCriacao);
    }

	//  public void atualizarEstoque(double quantidade) {
	//  this.quantidade = quantidade;
	//}

}
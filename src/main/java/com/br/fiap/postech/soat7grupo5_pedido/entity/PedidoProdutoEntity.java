package com.br.fiap.postech.soat7grupo5_pedido.entity;

import java.util.Objects;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoProdutoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedidoProduto;
	private int idPedido;
	private int idProduto;
    private Double precoProduto;
    private String nomeProduto;
    private int duracaoPreparo;
    
    public PedidoProdutoEntity() {
	}
    
    public PedidoProdutoEntity(PedidoProdutoDto pedidoProdutoDto) {
    	this.idPedidoProduto = pedidoProdutoDto.getIdPedidoProduto();
    	this.idPedido = pedidoProdutoDto.getIdPedido();
    	this.idProduto = pedidoProdutoDto.getIdProduto();
		this.nomeProduto = pedidoProdutoDto.getNomeProduto();
		this.precoProduto = pedidoProdutoDto.getPrecoProduto();
		this.duracaoPreparo = pedidoProdutoDto.getDuracaoPreparo();
	}
    
    public PedidoProdutoDto toPedidoProdutoDto() {
        return new PedidoProdutoDto(this.idPedidoProduto, this.idPedido, this.idProduto, this.nomeProduto, this.precoProduto, this.duracaoPreparo);
    }

	public void atualizar(PedidoProdutoDto pedidoProdutoDto) {
		this.idPedidoProduto = pedidoProdutoDto.getIdPedidoProduto();
		this.idPedido = pedidoProdutoDto.getIdPedido();
		this.idProduto = pedidoProdutoDto.getIdProduto();
		this.nomeProduto = Objects.nonNull(pedidoProdutoDto.getNomeProduto()) ? pedidoProdutoDto.getNomeProduto() : this.nomeProduto;
		this.precoProduto = Objects.nonNull(pedidoProdutoDto.getPrecoProduto()) ? pedidoProdutoDto.getPrecoProduto() : this.precoProduto;
		this.duracaoPreparo = (pedidoProdutoDto.getDuracaoPreparo() != 0) ? pedidoProdutoDto.getDuracaoPreparo() : this.duracaoPreparo;
	}

	public int getIdPedidoProduto() {
		return idPedidoProduto;
	}

	public void setIdPedidoProduto(int idPedidoProduto) {
		this.idPedidoProduto = idPedidoProduto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getDuracaoPreparo() {
		return duracaoPreparo;
	}

	public void setDuracaoPreparo(int duracaoPreparo) {
		this.duracaoPreparo = duracaoPreparo;
	}
	
}

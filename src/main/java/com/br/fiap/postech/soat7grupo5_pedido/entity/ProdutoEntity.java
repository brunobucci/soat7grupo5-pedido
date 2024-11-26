package com.br.fiap.postech.soat7grupo5_pedido.entity;

import java.util.Objects;

import com.br.fiap.postech.soat7grupo5_pedido.dto.ProdutoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduto;
	private String nome;
	private String descricao;
	private Double preco;
	private int duracaoPreparo;
	private int idTipo;
	private int flAtivo;

	public ProdutoEntity() {
	}

	public ProdutoEntity(ProdutoDto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.duracaoPreparo = produto.getDuracaoPreparo();
		this.idTipo = produto.getIdTipo();
		this.flAtivo = produto.getFlAtivo();
	}

	public void atualizar(ProdutoDto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = Objects.nonNull(produto.getNome()) ? produto.getNome() : this.nome;
		this.descricao = Objects.nonNull(produto.getDescricao()) ? produto.getDescricao() : this.descricao;
		this.preco = Objects.nonNull(produto.getPreco()) ? produto.getPreco() : this.preco;
		this.duracaoPreparo = (produto.getDuracaoPreparo() != 0) ? produto.getDuracaoPreparo() : this.duracaoPreparo;
		this.idTipo = (produto.getIdTipo() != 0) ? produto.getIdTipo() : this.idTipo;
		this.flAtivo = (produto.getFlAtivo() != 0) ? produto.getFlAtivo() : flAtivo;
	}

	public void desativar() {
		this.flAtivo = 0;
	}
	
	public ProdutoDto toProdutoDto() {
		return new ProdutoDto(this.idProduto, this.nome, this.descricao, this.preco, this.duracaoPreparo, this.idTipo, this.flAtivo);
	}
}

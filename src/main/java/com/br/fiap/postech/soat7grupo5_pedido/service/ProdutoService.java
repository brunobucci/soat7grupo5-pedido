package com.br.fiap.postech.soat7grupo5_pedido.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fiap.postech.soat7grupo5_pedido.dto.ProdutoDto;
import com.br.fiap.postech.soat7grupo5_pedido.entity.ProdutoEntity;
import com.br.fiap.postech.soat7grupo5_pedido.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDto> buscarProdutosPorCategoria(int idTipo) {
		List<ProdutoEntity> produtos = produtoRepository.findByIdTipo(idTipo);
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoEntity::toProdutoDto).collect(Collectors.toList());
        return produtoDtos;
	}

}

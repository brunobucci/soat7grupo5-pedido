package com.br.fiap.postech.soat7grupo5_pedido.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5_pedido.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository  extends CrudRepository<ProdutoEntity, Integer> {
	List<ProdutoEntity> findByIdTipo(int idTipo);
}
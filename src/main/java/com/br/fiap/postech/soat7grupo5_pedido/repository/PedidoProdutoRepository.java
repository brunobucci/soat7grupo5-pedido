package com.br.fiap.postech.soat7grupo5_pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoProdutoEntity;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProdutoEntity, Integer> {
	List<PedidoProdutoEntity> findByIdPedido(int idPedido);
}
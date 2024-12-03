package com.br.fiap.postech.soat7grupo5_pedido.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {
	List<PedidoEntity> findByIdClienteAndIdStatus(int idCliente, int idstatus);
}
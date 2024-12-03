package com.br.fiap.postech.soat7grupo5_pedido.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoDto;
import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoEntity;
import com.br.fiap.postech.soat7grupo5_pedido.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

    public PedidoDto salvarPedido(PedidoDto pedidoDto) {
    	PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);
    
    	if (pedidoDto.getIdPedido() == 0)
        	pedidoEntity = new PedidoEntity(pedidoDto);
        else {
        	pedidoEntity = pedidoRepository.findById(pedidoDto.getIdPedido()).get();
        	pedidoEntity.atualizar(pedidoDto);
        }
    	return pedidoRepository.save(pedidoEntity).toPedidoDto();
    }
    
    public List<PedidoDto> buscarPedidos() {
        List<PedidoEntity> pedidos = (List<PedidoEntity>) pedidoRepository.findAll();
        List<PedidoDto> pedidosDTOS = pedidos.stream().map(PedidoEntity::toPedidoDto).collect(Collectors.toList());
        return pedidosDTOS;
    }

    public PedidoDto buscarPedidoPorId(int idPedido) {
    	Optional<PedidoEntity> pedido = pedidoRepository.findById(idPedido);
    	PedidoDto PedidoDto = pedido.get().toPedidoDto();
		return PedidoDto;
	}
    
	public List<PedidoDto> buscarPedidosPorCliente(int idCliente) {
    	List<PedidoEntity> pedidos = pedidoRepository.findByIdClienteAndIdStatus(idCliente, 2);
        List<PedidoDto> PedidoDtoS = pedidos.stream().map(PedidoEntity::toPedidoDto).collect(Collectors.toList());
        return PedidoDtoS;
	}
	
}
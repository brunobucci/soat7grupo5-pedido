package com.br.fiap.postech.soat7grupo5_pedido.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoDto;

@SpringBootTest
//@AutoConfigureTestDatabase
@Transactional
class PedidoServiceTest {

	@Autowired
	private PedidoService pedidoService;
	

	@Test
	void devePermitirRegistrarPedido() {

		// Arrange
		int idPedido = new Random().ints(1, 10).findFirst().getAsInt();
		PedidoDto pedidoGerado = gerarPedido();
		pedidoGerado.setIdPedido(idPedido);

		when(pedidoService.salvarPedido(any(PedidoDto.class))).thenReturn(pedidoGerado);

		// Act
		PedidoDto pedidoGravado = pedidoService.salvarPedido(pedidoGerado);

		// Assert
		assertThat(pedidoGravado)
		.isNotNull()
		.isEqualTo(pedidoGerado);

		verify(pedidoService, times(1)).salvarPedido(any(PedidoDto.class));
	}

	private PedidoDto gerarPedido() {

		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setDataCriacao(new Date());
		pedidoDto.setDuracaoTotalPreparo(10);
		pedidoDto.setIdCliente(1);
		pedidoDto.setIdPagamento(1);
		pedidoDto.setIdPedido(0);
		pedidoDto.setIdStatus(1);
		pedidoDto.setIdStatusPagamento(0);
		pedidoDto.setPreco(15.0);

		return pedidoDto;
	}
}

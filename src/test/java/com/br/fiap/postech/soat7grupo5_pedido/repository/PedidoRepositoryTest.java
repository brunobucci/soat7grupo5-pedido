package com.br.fiap.postech.soat7grupo5_pedido.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoEntity;

@SpringBootTest
class PedidoRepositoryTest {

	@Mock
	private PedidoRepository pedidoRepository;
	
	AutoCloseable openMocks;
	
	@BeforeEach
	void setup() {
		openMocks = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void devePermitirRegistrarPedido() {
		
		// Arrange
		PedidoEntity pedidoGerado = gerarPedido();
		
		when(pedidoRepository.save(any(PedidoEntity.class))).thenReturn(pedidoGerado);
		
		
		// Act
		PedidoEntity pedidoGravado = pedidoRepository.save(pedidoGerado);
		
		// Assert
		assertThat(pedidoGravado)
			.isNotNull()
			.isEqualTo(pedidoGerado);
		
		verify(pedidoRepository, times(1)).save(any(PedidoEntity.class));
	}
	
	@Test
	void devePermitirBuscarPedido() {
		
		// Arrange
		int idPedido = new Random().ints(1, 10).findFirst().getAsInt();
		PedidoEntity pedidoGerado = gerarPedido();
		pedidoGerado.setIdPedido(idPedido);
		
		when(pedidoRepository.findById(any(Integer.class))).thenReturn(Optional.of(pedidoGerado));
		
		
		// Act
		Optional<PedidoEntity> pedidoGravadoOpcional = pedidoRepository.findById(idPedido);
		
		// Assert
		assertThat(pedidoGravadoOpcional)
			.isPresent()
			.containsSame(pedidoGerado);
		
		pedidoGravadoOpcional.ifPresent(pedidoGravado -> {
			assertThat(pedidoGravado.getIdPedido()).isEqualTo(pedidoGerado.getIdPedido());
			assertThat(pedidoGravado.getDuracaoTotalPreparo()).isEqualTo(pedidoGerado.getDuracaoTotalPreparo());
		});
		
		
		verify(pedidoRepository, times(1)).findById(any(Integer.class));
	}
	
	@Test
	void devePermitirBuscarPedidoPorIdClienteEIdStatus() {
		// Arrange
		var pedido1 = gerarPedido();
		var pedido2 = gerarPedido();
		var pedido3 = gerarPedido();
		var listaPedidos = new ArrayList<PedidoEntity>();
		listaPedidos.add(pedido1);
		listaPedidos.add(pedido2);
		listaPedidos.add(pedido3);
		when(pedidoRepository.findByIdClienteAndIdStatus(any(Integer.class), any(Integer.class))).thenReturn((List<PedidoEntity>) listaPedidos);
		
		// Act
		List<PedidoEntity> pedidosGravados = pedidoRepository.findByIdClienteAndIdStatus(pedido1.getIdCliente(), pedido1.getIdStatus());
		
		// Assert
		assertThat(pedidosGravados)
		.hasSize(3)
		.containsExactlyInAnyOrder(pedido1, pedido2, pedido3);
	
		verify(pedidoRepository, times(1)).findByIdClienteAndIdStatus(any(Integer.class), any(Integer.class));
		
	}
	
	@Test
	void devePermitirListarPedidos() {
		
		// Arrange
		var pedido1 = gerarPedido();
		var pedido2 = gerarPedido();
		var pedido3 = gerarPedido();
		var listaPedidos = new ArrayList<PedidoEntity>();
		listaPedidos.add(pedido1);
		listaPedidos.add(pedido2);
		listaPedidos.add(pedido3);
		when(pedidoRepository.findAll()).thenReturn((Iterable<PedidoEntity>) listaPedidos);
		
		
		// Act
		Iterable<PedidoEntity> pedidosRecebidos = pedidoRepository.findAll();
		
		// Assert
		assertThat(pedidosRecebidos)
			.hasSize(3)
			.containsExactlyInAnyOrder(pedido1, pedido2, pedido3);
		
		verify(pedidoRepository, times(1)).findAll();
	}
	
	
	private PedidoEntity gerarPedido() {
		
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setDataCriacao(new Date());
		pedidoEntity.setDuracaoTotalPreparo(10);
		pedidoEntity.setIdCliente(1);
		pedidoEntity.setIdPagamento(1);
		pedidoEntity.setIdPedido(0);
		pedidoEntity.setIdStatus(1);
		pedidoEntity.setIdStatusPagamento(0);
		pedidoEntity.setPreco(15.0);
		
		return pedidoEntity;
	}
	
}

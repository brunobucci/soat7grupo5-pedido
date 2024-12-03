package com.br.fiap.postech.soat7grupo5_pedido.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@AutoConfigureTestDatabase
@Transactional
class PedidoProdutoRepositoryTest {

	@Mock
	private ProdutoRepository produtoRepository;
	
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
	void devePermitirBuscarPedidoProdutoPorId() {
		//fail("teste não implementado.");
	}
	
}

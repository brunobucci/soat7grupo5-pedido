package com.br.fiap.postech.soat7grupo5_pedido.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutoRepositoryTest {

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
	
	//@Test
	void devePermitirBuscarProdutoPorTipo() {
		//fail("teste não implementado.");
	}
	
}

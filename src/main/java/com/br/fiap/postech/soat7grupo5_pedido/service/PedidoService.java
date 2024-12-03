package com.br.fiap.postech.soat7grupo5_pedido.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.fiap.postech.soat7grupo5_pedido.dto.PagamentoApiDto;
import com.br.fiap.postech.soat7grupo5_pedido.dto.PedidoDto;
import com.br.fiap.postech.soat7grupo5_pedido.dto.ProducaoApiDto;
import com.br.fiap.postech.soat7grupo5_pedido.entity.PedidoEntity;
import com.br.fiap.postech.soat7grupo5_pedido.repository.PedidoRepository;
import com.google.gson.Gson;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Value("${url.api.pagamento}")
    String urlApiPagamento;

	@Value("${url.api.producao}")
    String urlApiProducao;
	
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
    	List<PedidoEntity> pedidos = pedidoRepository.findByIdCliente(idCliente);
        return pedidos.stream().map(PedidoEntity::toPedidoDto).collect(Collectors.toList());
	}

	public void atualizarStatusPagamentoPedido(PedidoDto pedidoDto) {
		// Pagamento aprovado
		if(pedidoDto.getIdStatusPagamento() == 1) {
			pedidoDto.setIdStatus(2);
			salvarPedido(pedidoDto);
			ProducaoApiDto producaoApiDto = new ProducaoApiDto();
			producaoApiDto.setIdPedido(pedidoDto.getIdPedido());
			producaoApiDto.setStatus(1);
			
			registraPedidoNaProducaoAPI(producaoApiDto);
		}
		else if(pedidoDto.getIdStatusPagamento() == 2) {
			pedidoDto.setIdStatus(6);
			salvarPedido(pedidoDto);
		}
	}
	
	private void registraPedidoNaProducaoAPI(ProducaoApiDto producaoApiDto) {
		try {
			Gson gson = new Gson();
			RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String producaoApiDtoJson = gson.toJson(producaoApiDto);
            
            HttpEntity<String> request = new HttpEntity<>(producaoApiDtoJson, headers);

			restTemplate.postForObject(
					urlApiProducao + "/registrar",
                    request,
                    String.class
            );
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void registrarSolicitacaoPagamento(PedidoDto pedidoDto) {
		try {
			
			PagamentoApiDto pagamentoApiDto = new PagamentoApiDto();
			pagamentoApiDto.setIdPedido(pedidoDto.getIdPedido());
			pagamentoApiDto.setIdPagamento(pedidoDto.getIdPagamento());
			pagamentoApiDto.setIdStatusPagamento(0);
			
			Gson gson = new Gson();
			RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String pagamentoApiDtoJson = gson.toJson(pagamentoApiDto);
            
            HttpEntity<String> request = new HttpEntity<>(pagamentoApiDtoJson, headers);

			restTemplate.postForObject(
					urlApiPagamento + "registrar",
                    request,
                    PagamentoApiDto.class
            );
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
package com.cafeteria.mapper;

import org.springframework.stereotype.Component;

import com.cafeteria.dtos.CompraConfirmadaDTO;
import com.cafeteria.models.CompraConfirmado;

@Component
public class CompraConfirmadaMapper {

	public CompraConfirmadaDTO toDTO(CompraConfirmado compraConfirmado) {
		return new CompraConfirmadaDTO(compraConfirmado.getId(), compraConfirmado.getNome(), compraConfirmado.getPreco(), compraConfirmado.getImagem(), compraConfirmado.getData());
	}
	
	public CompraConfirmado toEntity(CompraConfirmadaDTO compraConfirmadaDTO) {
		var compraConfirmada = new CompraConfirmado();
		compraConfirmada.setId(compraConfirmadaDTO.id());
		compraConfirmada.setNome(compraConfirmadaDTO.nome());
		compraConfirmada.setPreco(compraConfirmadaDTO.preco());
		compraConfirmada.setImagem(compraConfirmadaDTO.imagem());
		compraConfirmada.setData(compraConfirmadaDTO.data());
		return compraConfirmada;
	}
}

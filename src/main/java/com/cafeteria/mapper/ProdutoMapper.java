package com.cafeteria.mapper;


import org.springframework.stereotype.Component;

import com.cafeteria.dtos.ProdutoDTO;
import com.cafeteria.models.Produto;
@Component
public class ProdutoMapper {

	public ProdutoDTO toDTO(Produto produto) {
		return new ProdutoDTO(produto.getNome(),produto.getPreco(),produto.getImagem());
	}
	
	public Produto toEntity(ProdutoDTO produtoDTO) {
		var produto = new Produto();
		produto.setNome(produtoDTO.nome());
		produto.setPreco(produtoDTO.preco());
		produto.setImagem(produtoDTO.imagem());
		return produto;
	}
	
}

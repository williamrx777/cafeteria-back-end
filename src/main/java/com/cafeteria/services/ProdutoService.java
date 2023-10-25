package com.cafeteria.services;

import java.util.List;

import com.cafeteria.dtos.ProdutoDTO;

public interface ProdutoService {
	
	List<ProdutoDTO> listarTodos();
	
	ProdutoDTO publicar( ProdutoDTO produtoDTO);
	
	ProdutoDTO pegaUm( Long id);
	
	ProdutoDTO atualizar( Long id, ProdutoDTO produtoDTO);
	
	void deletar(Long id);
	

}

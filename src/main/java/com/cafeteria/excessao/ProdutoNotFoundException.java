package com.cafeteria.excessao;

public class ProdutoNotFoundException extends RuntimeException{

	public ProdutoNotFoundException(Long id) {
		super("Produto não encontrado" + id);
	}
	
}

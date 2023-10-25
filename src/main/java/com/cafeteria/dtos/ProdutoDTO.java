package com.cafeteria.dtos;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String nome, BigDecimal preco, String imagem) {

}

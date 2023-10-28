package com.cafeteria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoDTO(@NotBlank String nome, @NotNull BigDecimal preco,@NotBlank String imagem) {

}

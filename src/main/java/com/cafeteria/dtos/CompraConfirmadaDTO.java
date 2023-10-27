package com.cafeteria.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CompraConfirmadaDTO(Long id, String nome, BigDecimal preco, String imagem, LocalDate data) {

}

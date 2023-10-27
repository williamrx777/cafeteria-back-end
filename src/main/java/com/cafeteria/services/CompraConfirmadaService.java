package com.cafeteria.services;

import java.util.List;

import com.cafeteria.dtos.CompraConfirmadaDTO;

public interface CompraConfirmadaService {
	
	List<CompraConfirmadaDTO> findAll();
	
	CompraConfirmadaDTO post(CompraConfirmadaDTO compraConfirmadaDTO);
	
	CompraConfirmadaDTO getOne(Long id);
	
	CompraConfirmadaDTO update(Long id, CompraConfirmadaDTO compraConfirmadaDTO);
	
	void delete(Long id);
	
}

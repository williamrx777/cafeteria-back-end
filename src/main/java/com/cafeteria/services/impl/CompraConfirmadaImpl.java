package com.cafeteria.services.impl;

import java.util.List;

import com.cafeteria.dtos.CompraConfirmadaDTO;
import com.cafeteria.excessao.ProdutoNotFoundException;
import com.cafeteria.mapper.CompraConfirmadaMapper;
import com.cafeteria.repositories.CompraConfirmadaRepository;
import com.cafeteria.services.CompraConfirmadaService;
import org.springframework.stereotype.Service;

@Service
public class CompraConfirmadaImpl implements CompraConfirmadaService{

	private final CompraConfirmadaRepository compraConfirmadaRepository;
	
	private final CompraConfirmadaMapper compraConfirmadaMapper;
	
	public CompraConfirmadaImpl(CompraConfirmadaRepository compraConfirmadaRepository,
			CompraConfirmadaMapper compraConfirmadaMapper) {
		this.compraConfirmadaRepository = compraConfirmadaRepository;
		this.compraConfirmadaMapper = compraConfirmadaMapper;
	}

	@Override
	public List<CompraConfirmadaDTO> findAll() {
		// TODO Auto-generated method stub
		return compraConfirmadaRepository.findAll().stream().map(compraConfirmadaMapper::toDTO).toList();
	}

	@Override
	public CompraConfirmadaDTO post(CompraConfirmadaDTO compraConfirmadaDTO) {
		// TODO Auto-generated method stub
		return compraConfirmadaMapper.toDTO(compraConfirmadaRepository.save(compraConfirmadaMapper.toEntity(compraConfirmadaDTO)));
	}

	@Override
	public CompraConfirmadaDTO getOne(Long id) {
		// TODO Auto-generated method stub
		return compraConfirmadaRepository.findById(id).map(compraConfirmadaMapper::toDTO).orElseThrow(() -> new ProdutoNotFoundException(id));
	}

	@Override
	public CompraConfirmadaDTO update(Long id, CompraConfirmadaDTO compraConfirmadaDTO) {
		// TODO Auto-generated method stub
		return compraConfirmadaRepository.findById(id)
				.map(compraConfirmada -> {
					compraConfirmada.setId(compraConfirmadaDTO.id());
					compraConfirmada.setNome(compraConfirmadaDTO.nome());
					compraConfirmada.setPreco(compraConfirmadaDTO.preco());
					compraConfirmada.setImagem(compraConfirmadaDTO.imagem());
					compraConfirmada.setData(compraConfirmadaDTO.data());
					return compraConfirmadaMapper.toDTO(compraConfirmadaRepository.save(compraConfirmada));
				}).orElseThrow(() -> new ProdutoNotFoundException(id));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		compraConfirmadaRepository.deleteById(id);
	}

}

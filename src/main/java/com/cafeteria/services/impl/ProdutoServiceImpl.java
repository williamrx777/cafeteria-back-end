package com.cafeteria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cafeteria.dtos.ProdutoDTO;
import com.cafeteria.mapper.ProdutoMapper;
import com.cafeteria.repositories.ProdutoRepository;
import com.cafeteria.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	
	private final ProdutoRepository produtoRepository;
	private final ProdutoMapper produtoMapper;
	public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
		this.produtoRepository = produtoRepository;
		this.produtoMapper = produtoMapper;
	}
	
	@Override
	public List<ProdutoDTO> listarTodos() {
		return produtoRepository.findAll().stream().map(produtoMapper::toDTO).toList();
	}

	@Override
	public ProdutoDTO publicar(ProdutoDTO produtoDTO) {
		return produtoMapper.toDTO(produtoRepository.save(produtoMapper.toEntity(produtoDTO)));
	}

	@Override
	public ProdutoDTO pegaUm(Long id) {
		return produtoRepository.findById(id).map(produtoMapper::toDTO).orElseThrow();
	}

	@Override
	public ProdutoDTO atualizar(Long id, ProdutoDTO produtoDTO) {
		return produtoRepository.findById(id)
				.map(produto -> {
					produto.setId(produtoDTO.id());
					produto.setNome(produtoDTO.nome());
					produto.setPreco(produtoDTO.preco());
					produto.setImagem(produtoDTO.imagem());
					return produtoMapper.toDTO(produtoRepository.save(produto));
				}).orElseThrow();
	}

	@Override
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
		
	}

}

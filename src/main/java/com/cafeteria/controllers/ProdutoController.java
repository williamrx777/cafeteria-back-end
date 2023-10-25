package com.cafeteria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.dtos.ProdutoDTO;
import com.cafeteria.services.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarTodos(){
		var listarTodos = produtoService.listarTodos();
		return ResponseEntity.ok(listarTodos);
	}
	@PostMapping
	public ResponseEntity<ProdutoDTO> publica(@RequestBody ProdutoDTO produtoDTO) {
		produtoService.publicar(produtoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> pegaUm(@PathVariable Long id ) {
		return ResponseEntity.ok(produtoService.pegaUm(id));
	}
	@PutMapping
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id ,@RequestBody ProdutoDTO produtoDTO) {
		return ResponseEntity.ok(produtoService.atualizar(id, produtoDTO));
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id ) {
		produtoService.deletar(id);
	}
	
}

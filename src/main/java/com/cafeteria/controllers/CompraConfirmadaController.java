package com.cafeteria.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafeteria.dtos.CompraConfirmadaDTO;
import com.cafeteria.services.CompraConfirmadaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/compras-confirmas")
public class CompraConfirmadaController {
	
	private final CompraConfirmadaService compraConfirmadaService;

	public CompraConfirmadaController(CompraConfirmadaService compraConfirmadaService) {
		this.compraConfirmadaService = compraConfirmadaService;
	}
	
	@GetMapping
	public ResponseEntity<List<CompraConfirmadaDTO>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(compraConfirmadaService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CompraConfirmadaDTO> post(@RequestBody CompraConfirmadaDTO compraConfirmadaDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(compraConfirmadaService.post(compraConfirmadaDTO));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompraConfirmadaDTO> getOne(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(compraConfirmadaService.getOne(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompraConfirmadaDTO> update(@PathVariable Long id, @RequestBody CompraConfirmadaDTO compraConfirmadaDTO){
		return ResponseEntity.status(HttpStatus.OK).body(compraConfirmadaService.update(id, compraConfirmadaDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		compraConfirmadaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

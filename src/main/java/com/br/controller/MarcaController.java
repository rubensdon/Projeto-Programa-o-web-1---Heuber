package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import com.br.Exception.ResourceNotFoundException;
import com.br.Marca;
import com.br.repository.MarcaRepository;


@RequestMapping("/cmarca/")
@RestController
@CrossOrigin(origins="*")
public class MarcaController {
	
	//cria o repositorio jpa de forma automatica e autogrernciado
	
	@Autowired
	private MarcaRepository mrep;
	
	
	@GetMapping ("/marca")
	
	public List<Marca> listar(){
		
		return this.mrep.findAll(Sort.by(Sort.Direction.DESC,"codigo"));
	}

	
	@GetMapping("/marca/{id}")
	public ResponseEntity<Marca> consultar(@PathVariable Long id){
		
		
		Marca marca = this.mrep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Marca nao encontrada:" + id));
				
		return ResponseEntity.ok(marca);
	}
	
	
	@PostMapping("/marca")
	public Marca inserir (@RequestBody Marca marca) {
		return this.mrep.save(marca);
	}
}

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
import com.br.Automovel;
import com.br.repository.AutomovelRepository;


@RequestMapping("/cautomovel/")
@RestController
@CrossOrigin(origins="*")
public class AutomovelController {
	
	
	@Autowired
	private AutomovelRepository mrep;
	
	
	@GetMapping ("/automovel")
	
	public List<Automovel> listar(){
		
		return this.mrep.findAll(Sort.by(Sort.Direction.DESC,"codigo"));
	}

	
	@GetMapping("/automovel/{id}")
	public ResponseEntity<Automovel> consultar(@PathVariable Long id){
		
		
		Automovel automovel = this.mrep.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Automovel nao encontrada:" + id));
				
		return ResponseEntity.ok(automovel);
	}
	
	
	@PostMapping("/automovel")
	public Automovel inserir (@RequestBody Automovel automovel) {
		return this.mrep.save(automovel);
	}
}

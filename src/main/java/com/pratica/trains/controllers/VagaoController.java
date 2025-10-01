package com.pratica.trains.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratica.trains.dto.VagaoDTO;
import com.pratica.trains.services.VagaoService;

@RestController
@RequestMapping(value = "/vagoes")
public class VagaoController {
	
	@Autowired
	private VagaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VagaoDTO> getVagaoByID(@PathVariable Long id) {
		VagaoDTO dto = service.getVagaoByID(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<VagaoDTO> createVagao(@RequestBody VagaoDTO dto){
		VagaoDTO result = service.createVagao(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<VagaoDTO> updateVagao(@RequestBody VagaoDTO dto, @PathVariable Long id) {
		VagaoDTO result = service.updateVagao(dto, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteVagao(@PathVariable Long id){
		service.deleteVagao(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	

}

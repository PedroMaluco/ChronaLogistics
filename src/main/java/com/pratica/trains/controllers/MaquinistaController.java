package com.pratica.trains.controllers;

import java.net.URI;
import java.util.List;

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

import com.pratica.trains.dto.MaquinistaDTO;
import com.pratica.trains.services.MaquinistaService;

@RestController
@RequestMapping(value = "/personel")
public class MaquinistaController {
	
	@Autowired
	private MaquinistaService maquiServ;
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<MaquinistaDTO> findMaqui(@PathVariable Long id) {
		MaquinistaDTO maqui = maquiServ.findById(id);	
		return ResponseEntity.ok(maqui);
	}
	
	@GetMapping
	private ResponseEntity<List<MaquinistaDTO>> findAll() {
		List<MaquinistaDTO> list = maquiServ.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	private ResponseEntity<MaquinistaDTO> addMaqui(@RequestBody MaquinistaDTO dto) {
		MaquinistaDTO result = maquiServ.addMaqui(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}
	
	@PutMapping(value = "/{id}")
	private ResponseEntity<MaquinistaDTO> updateMaqui(@RequestBody MaquinistaDTO dto, @PathVariable Long id) {
		MaquinistaDTO result = maquiServ.updateMaqui(dto, id);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping(value = "/{id}")
	private ResponseEntity<Void> deleteMaqui(@PathVariable Long id) {
		maquiServ.deleteMaqui(id);
		return ResponseEntity.noContent().build();
		
	}
	

}

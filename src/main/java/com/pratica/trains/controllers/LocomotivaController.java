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

import com.pratica.trains.dto.LocomotivaDTO;
import com.pratica.trains.services.LocomotivaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/chronaLog")
public class LocomotivaController {
	
	@Autowired
	LocomotivaService locoSer;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LocomotivaDTO> findLocoTest(@PathVariable Long id) {
		LocomotivaDTO dto = locoSer.findLoco(id);
		return ResponseEntity.ok(dto);
	}
	@GetMapping
	public ResponseEntity<List<LocomotivaDTO>> findAllLoco(){
		List<LocomotivaDTO> dto = locoSer.findAllLoco();
		return ResponseEntity.ok(dto);
	}
	@PostMapping(value = "/Locomotiva")
	public ResponseEntity<LocomotivaDTO> addLoco(@Valid @RequestBody LocomotivaDTO dto) {
		dto = locoSer.addLoco(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<LocomotivaDTO> updateLoco(@PathVariable Long id, @Valid @RequestBody LocomotivaDTO dto) {
		dto = locoSer.updateLoco(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLoco(@PathVariable Long id) {
		locoSer.deleteLoco(id);
		return ResponseEntity.noContent().build();
	}
	
}

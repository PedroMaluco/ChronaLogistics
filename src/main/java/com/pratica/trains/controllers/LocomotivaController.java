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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratica.trains.dto.LocomotivaDTO;
import com.pratica.trains.dto.LocomotivaMinDTO;
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
	public ResponseEntity<List<LocomotivaMinDTO>> findAllLoco(@RequestParam(name = "nome", defaultValue = "") String nome){
		List<LocomotivaMinDTO> dto = locoSer.findAllLoco(nome);
		return ResponseEntity.ok(dto);
	}
	@PostMapping
	public ResponseEntity<LocomotivaMinDTO> addLoco(@Valid @RequestBody LocomotivaDTO dto) {
		LocomotivaMinDTO result = locoSer.addLoco(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
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
	@PutMapping(value = "/{idMaqui}/{idLoco}")
	public ResponseEntity<LocomotivaDTO> setMaquinista(@PathVariable Long idMaqui, @PathVariable Long idLoco){
		LocomotivaDTO dto = locoSer.setMaqui(idMaqui, idLoco);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(value = "/addVag/{idVagao}/{idLoco}")
	public ResponseEntity<LocomotivaDTO> addVagaoToLocomotiva(@PathVariable Long idVagao, @PathVariable Long idLoco){
		LocomotivaDTO dto = locoSer.addVagaoToLocomotiva(idVagao, idLoco);
		return ResponseEntity.ok(dto);
	}
	
}

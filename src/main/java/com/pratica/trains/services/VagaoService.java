package com.pratica.trains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.VagaoDTO;
import com.pratica.trains.entities.Vagao;
import com.pratica.trains.repositories.VagaoRepository;
import com.pratica.trains.services.exceptions.ObjectNotFoundException;

@Service
public class VagaoService {
	
	@Autowired
	private VagaoRepository repository;
	
	@Transactional(readOnly = true)
	public VagaoDTO getVagaoByID(Long id) {
		Vagao vagao = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Vagão não encontrado"));
		VagaoDTO dto = new VagaoDTO(vagao);
		return dto;
	}
	
	@Transactional
	public VagaoDTO createVagao(VagaoDTO dto) {
		Vagao vagao = new Vagao();
		vagao.setAno(dto.getAno());
		vagao.setModelo(dto.getModelo());
		vagao.setPeso(dto.getPeso());
		vagao = repository.save(vagao);
	
		return new VagaoDTO(vagao);
	}
	
	

}

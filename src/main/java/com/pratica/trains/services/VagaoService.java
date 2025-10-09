package com.pratica.trains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.VagaoDTO;
import com.pratica.trains.entities.Vagao;
import com.pratica.trains.repositories.VagaoRepository;
import com.pratica.trains.services.exceptions.DatabaseException;
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
	
	@Transactional
	public VagaoDTO updateVagao(VagaoDTO dto, Long id) {
		Vagao vagao = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Vagão não encontrado"));
		vagao.setAno(dto.getAno());
		vagao.setModelo(dto.getModelo());
		vagao.setPeso(dto.getPeso());
		vagao = repository.save(vagao);
		
		return new VagaoDTO(vagao);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteVagao(Long id) {
		if(!repository.existsById(id)) {
			throw new ObjectNotFoundException("Locomotiva não encontrada");
			}
		try {
			repository.deleteById(id);;
			}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");		
			}
		}
	
}

package com.pratica.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.LocomotivaDTO;
import com.pratica.trains.entities.Locomotiva;
import com.pratica.trains.repositories.LocomotivaRepository;
import com.pratica.trains.services.exceptions.DatabaseException;
import com.pratica.trains.services.exceptions.LocoNotFoundException;

@Service
public class LocomotivaService {
	
	@Autowired
	private LocomotivaRepository locoRepo;
	
	@Transactional(readOnly = true)
	public LocomotivaDTO findLoco(Long id) {
		Locomotiva loco = locoRepo.findById(id).orElseThrow(() -> new LocoNotFoundException("Locomotiva não encontrada"));
		LocomotivaDTO locoDto = new LocomotivaDTO(loco);
		return locoDto;
	}
	
	@Transactional(readOnly = true)
	public List<LocomotivaDTO> findAllLoco(){
		List<Locomotiva>locomotivas = locoRepo.findAll();
		return locomotivas.stream().map(x->new LocomotivaDTO(x)).toList();
		
	}
	
	@Transactional
	public LocomotivaDTO addLoco(LocomotivaDTO dto) {
		Locomotiva loco = new Locomotiva();
		copiarDtoParaLoco(dto, loco);
		loco = locoRepo.save(loco);
		return new LocomotivaDTO(loco);
	}
	
	@Transactional
	public LocomotivaDTO updateLoco(Long id, LocomotivaDTO dto) {
		Locomotiva loco = locoRepo.findById(id).orElseThrow(() -> new LocoNotFoundException("Locomotiva não encontrada"));
		copiarDtoParaLoco(dto, loco);	
		loco = locoRepo.save(loco);
		return new LocomotivaDTO(loco);
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteLoco(Long id) {
		if(!locoRepo.existsById(id)) {
			throw new LocoNotFoundException("Locomotiva não encontrada");
		}
		try {
			locoRepo.deleteById(id);;
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");		
		}
		/*
		catch (TransientObjectException e) {
			throw new UnsavedObjException("Objeto não salvo");
		}
		catch (InvalidDataAccessApiUsageException e) {
			throw new InvalidAcessException("Acesso inválido ao dado");
			
		}
		*/
	}

	private void copiarDtoParaLoco(LocomotivaDTO dto, Locomotiva loco) {
		loco.setAno(dto.getAno());
		loco.setKilometragem(dto.getKilometragem());
		loco.setModelo(dto.getModelo());
		loco.setNome(dto.getNome());	
	}
}

package com.pratica.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.LocomotivaDTO;
import com.pratica.trains.dto.LocomotivaMinDTO;
import com.pratica.trains.entities.Locomotiva;
import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.repositories.LocomotivaRepository;
import com.pratica.trains.repositories.MaquinistaRepository;
import com.pratica.trains.services.exceptions.DatabaseException;
import com.pratica.trains.services.exceptions.ObjectNotFoundException;

@Service
public class LocomotivaService {
	
	@Autowired
	private LocomotivaRepository locoRepo;
	
	@Autowired
	private MaquinistaRepository maquiRepo;
	
	
	@Transactional(readOnly = true)
	public LocomotivaDTO findLoco(Long id) {
		Locomotiva loco = locoRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Locomotiva não encontrada"));
		LocomotivaDTO locoDto = new LocomotivaDTO(loco);
		return locoDto;
	}
	
	@Transactional(readOnly = true)
	public List<LocomotivaMinDTO> findAllLoco(String nome){
		List<Locomotiva>locomotivas = locoRepo.search1(nome);
		return locomotivas.stream().map(x->new LocomotivaMinDTO(x)).toList();
		
	}
	
	@Transactional
	public LocomotivaMinDTO addLoco(LocomotivaDTO dto) {
		Locomotiva loco = new Locomotiva();
		copiarDtoParaLoco(dto, loco);
		loco = locoRepo.save(loco);
		return new LocomotivaMinDTO(loco);
	}
	
	@Transactional
	public LocomotivaDTO updateLoco(Long id, LocomotivaDTO dto) {
		Locomotiva loco = locoRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Locomotiva não encontrada"));
		copiarDtoParaLoco(dto, loco);
		loco = locoRepo.save(loco);
		return new LocomotivaDTO(loco);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteLoco(Long id) {
		if(!locoRepo.existsById(id)) {
			throw new ObjectNotFoundException("Locomotiva não encontrada");
			}
		try {
			locoRepo.deleteById(id);;
			}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");		
			}
		}
	
	@Transactional
		public LocomotivaDTO setMaqui(Long idMaqui, Long idLoco) {
			Locomotiva loco = locoRepo.getReferenceById(idLoco);
			Maquinista maqui = maquiRepo.getReferenceById(idMaqui);
			loco.setMaquinista(maqui);
			locoRepo.save(loco);
			return new LocomotivaDTO(loco);
		}
		
	

	private void copiarDtoParaLoco(LocomotivaDTO dto, Locomotiva loco) {
		loco.setAno(dto.getAno());
		loco.setKilometragem(dto.getKilometragem());
		loco.setModelo(dto.getModelo());
		loco.setNome(dto.getNome());	
	}
}

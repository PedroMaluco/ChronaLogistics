package com.pratica.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.MaquinistaDTO;
import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.repositories.MaquinistaRepository;
import com.pratica.trains.services.exceptions.DatabaseException;
import com.pratica.trains.services.exceptions.ObjectNotFoundException;

@Service
public class MaquinistaService {

	@Autowired
	private MaquinistaRepository maquiRepo;
	
	@Transactional(readOnly = true)
	public MaquinistaDTO findById(Long id) {
		Maquinista maqui = maquiRepo.findById(id).orElseThrow(()->new ObjectNotFoundException("Maquinista não encontrado"));
		MaquinistaDTO dto = new MaquinistaDTO(maqui);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<MaquinistaDTO> findAll() {
		List<Maquinista> maqui = maquiRepo.findAll();
		return maqui.stream().map(x -> new MaquinistaDTO(x)).toList();
	}
	
	@Transactional
	public MaquinistaDTO addMaqui(MaquinistaDTO dto) {
		Maquinista maqui = new Maquinista();
		copyFromDTO(maqui, dto);
		maquiRepo.save(maqui);
		return new MaquinistaDTO(maqui);
	}
	
	@Transactional
	public MaquinistaDTO updateMaqui(MaquinistaDTO dto, Long id) {
		Maquinista maqui = maquiRepo.findById(id).orElseThrow(()->new ObjectNotFoundException("Maquinista não encontrado"));
		copyFromDTO(maqui, dto);
		maquiRepo.save(maqui);
		return new MaquinistaDTO(maqui);
	}
	
	@Transactional
	public void deleteMaqui(Long id) {
		if(!maquiRepo.existsById(id)) {
			throw new ObjectNotFoundException("Maquinista não encontrado");
			}
		try {
			maquiRepo.deleteById(id);;
			}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");		
			}
	}
	
	public void copyFromDTO(Maquinista maqui, MaquinistaDTO dto) {
		maqui.setNome(dto.getNome());
		maqui.setEmail(dto.getEmail());
		maqui.setIdade(dto.getIdade());
		maqui.setSoldo(dto.getSoldo());
	}

	
	
	

}

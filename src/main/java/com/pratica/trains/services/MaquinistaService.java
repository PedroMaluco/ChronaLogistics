package com.pratica.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.MaquinistaDTO;
import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.entities.Role;
import com.pratica.trains.projections.MaquinistaProjection;
import com.pratica.trains.repositories.MaquinistaRepository;
import com.pratica.trains.services.exceptions.DatabaseException;
import com.pratica.trains.services.exceptions.ObjectNotFoundException;

@Service
public class MaquinistaService implements UserDetailsService {

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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
		/**
		List<MaquinistaProjection> result = maquiRepo.searchMaquinistaByEmail(username);
		if(result.size()==0) {
			throw new UsernameNotFoundException("User not found");
		}
		else {
			
		
			Maquinista maqui = new Maquinista();
			maqui.setEmail(username);
			maqui.setSenha(result.get(0).getSenha());
			for (MaquinistaProjection proj : result) {
			maqui.addRole(new Role(proj.getroleId(), proj.getAuthority()));
				}
					return maqui;
		}
	}
**/
	
	public void copyFromDTO(Maquinista maqui, MaquinistaDTO dto) {
		maqui.setNome(dto.getNome());
		maqui.setEmail(dto.getEmail());
		maqui.setIdade(dto.getIdade());
		maqui.setSoldo(dto.getSoldo());
	}

	
	
	

}

package com.pratica.trains.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.projections.MaquinistaProjection;

public interface MaquinistaRepository extends JpaRepository<Maquinista, Long> {
	
	@Query(value = "SELECT tb_maquinista.email AS username, tb_maquinista.senha, tb_role.id AS roleID, tb_role.authority "
			+ "FROM tb_maquinista "
			+ "INNER JOIN tb_maquinista_role ON tb_maquinista.id = tb_maquinista_role.maquinista_id "
			+ "INNER JOIN tb_role ON tb_role.id = tb_maquinista_role.role_id "
			+ "WHERE tb_maquinista.email = :username")
	List<MaquinistaProjection> searchMaquinistaByEmail(String username);
		
	

}

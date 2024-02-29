package com.retogblhit.retogblhit.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retogblhit.retogblhit.dto.RespuestaGenericaGETyPOSTDTO;
import com.retogblhit.retogblhit.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	@Query(value = "exec listar_personas ?1, ?2", nativeQuery = true)
	List<Map<RespuestaGenericaGETyPOSTDTO, ?>> listarPersonas(String param1, String param2);
	
}

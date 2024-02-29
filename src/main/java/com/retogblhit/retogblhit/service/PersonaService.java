package com.retogblhit.retogblhit.service;

import java.util.List;
import java.util.Map;

import com.retogblhit.retogblhit.dto.RespuestaGenericaGETyPOSTDTO;
import com.retogblhit.retogblhit.model.Persona;

public interface PersonaService extends ICrud<Persona, Long> {

	List<Map<RespuestaGenericaGETyPOSTDTO, ?>> listarPersonas(String param1, String param2);
	
}

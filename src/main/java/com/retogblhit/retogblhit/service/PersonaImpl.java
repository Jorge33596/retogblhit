package com.retogblhit.retogblhit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retogblhit.retogblhit.dto.RespuestaGenericaGETyPOSTDTO;
import com.retogblhit.retogblhit.model.Persona;
import com.retogblhit.retogblhit.repository.PersonaRepository;

@Service
public class PersonaImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona registrar(Persona obj) {
		// TODO Auto-generated method stub
		return personaRepository.save(obj);
	}

	@Override
	public Persona modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona listarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<RespuestaGenericaGETyPOSTDTO, ?>> listarPersonas(String param1, String param2) {
		// TODO Auto-generated method stub
		return personaRepository.listarPersonas(param1, param2);
	}

}

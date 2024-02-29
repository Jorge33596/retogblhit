package com.retogblhit.retogblhit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.retogblhit.retogblhit.dto.EstadoRespuesta;
import com.retogblhit.retogblhit.dto.InputListarPersonaDTO;
import com.retogblhit.retogblhit.dto.RespuestaGenericaGETyPOSTDTO;
import com.retogblhit.retogblhit.model.Persona;
import com.retogblhit.retogblhit.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@PostMapping("/registrar")
	public ResponseEntity<EstadoRespuesta> registrarEspecie(@RequestBody Persona persona) {

		Gson gson = new Gson();
		String json = gson.toJson(persona);
		System.out.println("JSON: " + json);

		EstadoRespuesta respuesta = new EstadoRespuesta();
		try {

			personaService.registrar(persona);

			respuesta.setEstado("1");
			respuesta.setDescripcion("Se registró la persona correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			respuesta.setEstado("-1");
			respuesta.setDescripcion("Error: " + e.getMessage());
		}

		return new ResponseEntity<EstadoRespuesta>(respuesta, HttpStatus.CREATED);
	}

	@PostMapping("/listar")
	public ResponseEntity<List<Map<RespuestaGenericaGETyPOSTDTO, ?>>> listarPersonas(
			@RequestBody InputListarPersonaDTO content) {

		System.out.println("JSON: " + content);
		List<Map<RespuestaGenericaGETyPOSTDTO, ?>> listadoEspecies = new ArrayList();
		try {

			listadoEspecies = personaService.listarPersonas(content.getNombre(), content.getApellido());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return new ResponseEntity<>(listadoEspecies, HttpStatus.OK);
	}

}

package com.retogblhit.retogblhit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "nombre")
    private String nombre;

	@Column(name = "apellido")
    private String apellido;

	@Column(name = "edad")
    private int edad;

	@Column(name = "correo")
    private String correo;
    
    
}

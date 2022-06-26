package com.examen.ExamenIntercam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 
	
	@NotNull(message = "Debes colocar el codigo postal")
	@Size(min = 6, max = 6, message = "El codigo postal debe ser de 6 digitos")
	private String codigoPostal;
	private String estado;

}

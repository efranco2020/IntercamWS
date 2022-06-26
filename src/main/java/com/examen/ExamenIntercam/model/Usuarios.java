package com.examen.ExamenIntercam.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuarios {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
	
	@NotNull(message = "El nombre no puede venir nulo")
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cuenta_id", referencedColumnName = "id")
	@Valid
	private Cuentas cuenta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion_id", referencedColumnName = "id")
	@Valid
	private Direccion direccion;
	
	
	
	
	
	
	
	

}

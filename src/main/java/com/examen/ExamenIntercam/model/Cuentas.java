package com.examen.ExamenIntercam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Cuentas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Min(value = 10, message = "El numero de cuenta debe ser de minimo 10 digitos")
	private Integer numeroCuenta;

	@DecimalMin(value = "0.1", inclusive = false, message = "Los ingresos deben ser mayores a 0")
	private float ingresos;

}

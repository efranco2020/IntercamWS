package com.examen.ExamenIntercam;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.examen.ExamenIntercam.model.Cuentas;
import com.examen.ExamenIntercam.model.Direccion;
import com.examen.ExamenIntercam.model.ResponseGeneric;
import com.examen.ExamenIntercam.model.Usuarios;


@SpringBootTest
class TestRest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	
	@Test
	public void guardarCliente() throws Exception {
		
		Usuarios usuario = new Usuarios();
		
		usuario.setApellidoMaterno("Almague");
		usuario.setApellidoPaterno("Santos");
		
		Cuentas cuenta = new Cuentas();
		cuenta.setIngresos(0);
		cuenta.setNumeroCuenta(0);
		
		usuario.setCuenta(cuenta);
		
		Direccion direccion = new Direccion();
		direccion.setCodigoPostal("74000");
		direccion.setEstado("Puebla");
		
		usuario.setDireccion(direccion);
		
		Date fechaNacimiento = Calendar.getInstance().getTime();
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setNombre("Javie");
		
		
		final String baseUrl = "http://127.0.0.1:8080/usuarios/guardarUsuario";
        URI uri = new URI(baseUrl);
		
        HttpEntity<Usuarios> request = new HttpEntity<>(usuario);
        
        ResponseEntity<ResponseGeneric> result = new RestTemplate().postForEntity(uri, request, ResponseGeneric.class);
         
        //Verify request succeed
        assertEquals(500, result.getStatusCodeValue());
	}

}

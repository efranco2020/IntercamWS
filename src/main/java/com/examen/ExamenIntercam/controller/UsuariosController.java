package com.examen.ExamenIntercam.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examen.ExamenIntercam.model.ResponseGeneric;
import com.examen.ExamenIntercam.model.Usuarios;
import com.examen.ExamenIntercam.service.UsuariosService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuariosController {

	@Autowired(required = true)
	private UsuariosService usuarioService;
	
	
	@RequestMapping(value="/guardarUsuario",method=RequestMethod.POST)
	public ResponseGeneric saveUsers(@Valid @RequestBody Usuarios u) {
		try {
		return usuarioService.saveUsers(u);
		}catch (Exception e) {
			ResponseGeneric response = new ResponseGeneric();
			
			response.setMensaje(e.getMessage());
			response.setResultado(false);
			
			return response;
		}
	}
	
	@RequestMapping(value="/buscar/All",method=RequestMethod.GET)
	public ResponseGeneric findAllUsuarios() {
		
		return usuarioService.findUsers();
	}
	
	@RequestMapping(value="/buscar/{id}",method=RequestMethod.GET)
	public ResponseGeneric findById(@PathVariable Integer id) {
		
		return usuarioService.findById(id);
	}
	
	@RequestMapping(value="/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseGeneric delById(@PathVariable Integer id) {
		
		return usuarioService.delUser(id);
	}
	
	@RequestMapping(value="/actualizar/{id}",method=RequestMethod.PUT)
	public ResponseGeneric setUsuario(@PathVariable Integer id, @RequestBody Usuarios u) {
		
		return usuarioService.setUser(id, u);
	}
	
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<String, String>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}

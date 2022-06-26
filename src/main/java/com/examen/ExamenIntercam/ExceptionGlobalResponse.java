package com.examen.ExamenIntercam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examen.ExamenIntercam.model.ResponseGeneric;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice 
public class ExceptionGlobalResponse {
	ResponseGeneric result;

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseGeneric> runtimeException(RuntimeException e) {
		e.printStackTrace();
		//result = new Response(Time.getTime(), "[RuntimeException Response] - Exception: " + e.toString(), 500, "Error");
		result  = new ResponseGeneric();
		result.setMensaje("[RuntimeException Response] - Exception: "+e.toString());
		result.setResultado(false);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseGeneric> exception(Exception e) {
		e.printStackTrace();
		result  = new ResponseGeneric();
		result.setMensaje("[Exception Response] - Exception: "+e.toString());
		result.setResultado(false);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ResponseGeneric> invalidFormatException(InvalidFormatException e) {
		e.printStackTrace();
		result  = new ResponseGeneric();
		result.setMensaje("[InvalidFormatException Response] - Exception: "+e.getPathReference());
		result.setResultado(false);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseGeneric> invalidFormatException(HttpMessageNotReadableException e) {
		if(e.getCause()  instanceof InvalidFormatException) {
			InvalidFormatException invExc = (InvalidFormatException) e.getCause();
			if(invExc.toString().contains("expected format")) {
				result  = new ResponseGeneric();
				result.setMensaje("El formato en la fecha de nacimiento es incorrecto, debe ser dd/mm/yyyy");
				result.setResultado(false);
			}else {
				e.printStackTrace();
				result  = new ResponseGeneric();
				result.setMensaje("[InvalidFormatException Response] - Exception: "+invExc.getLocation().contentReference().buildSourceDescription());
				result.setResultado(false);
			}
			
			
		}else {
			e.printStackTrace();
			result  = new ResponseGeneric();
			result.setMensaje("[HttpMessageNotReadableException Response] - Exception: "+e.getMostSpecificCause().getMessage());
			result.setResultado(false);
		}
		
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
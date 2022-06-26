package com.examen.ExamenIntercam.service.impl;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ExamenIntercam.model.ResponseGeneric;
import com.examen.ExamenIntercam.model.Usuarios;
import com.examen.ExamenIntercam.repository.UsuariosRepository;
import com.examen.ExamenIntercam.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private UsuariosRepository usuarioRepositorio;

	@Override
	public ResponseGeneric saveUsers(Usuarios usuarios){
		ResponseGeneric salida = new ResponseGeneric();
		try {
			usuarioRepositorio.save(usuarios);
			salida.setResultado(true);
			return salida;
		}  catch (Exception e) {
			e.printStackTrace();
			salida.setResultado(false);
			salida.setMensaje("Exc: "+e.getMessage());
			return salida;
		}
	}

	@Override
	public ResponseGeneric findUsers() {
		ResponseGeneric salida = new ResponseGeneric();
		List<Usuarios> lista = null;
		try {
			lista= usuarioRepositorio.findAll();
			salida.setResultado(lista);
			return salida;
		} catch (Exception e) {
			e.printStackTrace();
			salida.setMensaje(e.getMessage());
			return salida;
		}
	}

	@Override
	public ResponseGeneric findById(Integer id) {
		ResponseGeneric salida = new ResponseGeneric();
		Usuarios lista = null;
		try {
			lista= usuarioRepositorio.findById(id);
			if(lista != null) {
				salida.setResultado(lista);
				return salida;	
			}
			
			salida.setMensaje("No se encontro el ID.");
			return salida;
		} catch (Exception e) {
			e.printStackTrace();
			salida.setMensaje(e.getMessage());
			return salida;
		}
	}

	@Override
	public ResponseGeneric delUser(Integer id) {
		ResponseGeneric salida = new ResponseGeneric();
		try {
			
			ResponseGeneric resp = findById(id);
			Usuarios user = (Usuarios) resp.getResultado();
			if(user != null ) {
				usuarioRepositorio.delete(user);
				salida.setResultado(true);
				return salida;
			}			
			salida.setResultado(false);
			salida.setMensaje("El ID indicado para eliminar, no existe.");
			return salida;
		} catch (Exception e) {
			e.printStackTrace();
			salida.setResultado(false);
			salida.setMensaje(e.getMessage());
			return salida;
		}
	}
	
	@Override
	public ResponseGeneric setUser(Integer id, Usuarios usuarios) {
		ResponseGeneric salida = new ResponseGeneric();
		try {
			ResponseGeneric resp = findById(id);
			Usuarios lista = (Usuarios) resp.getResultado();
			if(lista != null ) {
				usuarios.setId(id);
				usuarioRepositorio.save(usuarios);	
				salida.setResultado(true);
				return salida;
			}
			salida.setResultado(false);
			salida.setMensaje("No existe el id");
			return salida;
		} catch (ConstraintViolationException | org.hibernate.exception.ConstraintViolationException e) {
			salida.setResultado(false);
			salida.setMensaje(e.getMessage());
			return salida;
		} catch (Exception e) {
			e.printStackTrace();
			salida.setResultado(false);
			salida.setMensaje(e.getMessage());
			return salida;
		}
	}


}

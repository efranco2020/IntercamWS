package com.examen.ExamenIntercam.service;


import com.examen.ExamenIntercam.model.ResponseGeneric;
import com.examen.ExamenIntercam.model.Usuarios;

public interface UsuariosService {
	
	
	public ResponseGeneric saveUsers(Usuarios usuarios);
	public ResponseGeneric findUsers();
	public ResponseGeneric findById(Integer id );
	public ResponseGeneric delUser(Integer id );
	public ResponseGeneric setUser(Integer id, Usuarios usuarios);
	

}

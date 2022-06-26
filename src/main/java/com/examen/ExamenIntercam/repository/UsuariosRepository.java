package com.examen.ExamenIntercam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.ExamenIntercam.model.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
	
	public Usuarios findById(Integer id);
	public List<Usuarios>  findAll();

}

package org.ciberfarma.repository;

import java.util.List;

import org.ciberfarma.Model.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarreraRepository extends JpaRepository<Carrera, String>{

	//listado de productos por categoria
	List<Carrera> findByIdcarrera(int idcarrera);
}

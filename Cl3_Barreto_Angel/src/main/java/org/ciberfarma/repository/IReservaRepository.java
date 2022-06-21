package org.ciberfarma.repository;

import org.ciberfarma.Model.reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository<reserva, Integer>{
	
	// se van a autogenerar los metodos del crud
	
	
}

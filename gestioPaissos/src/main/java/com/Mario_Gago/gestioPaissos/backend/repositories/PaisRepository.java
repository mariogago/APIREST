package com.Mario_Gago.gestioPaissos.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

	//@Query("SELECT p FROM PAISSOS p WHERE NUMHABITANTES >= :min AND NUMHABITANTES <= :max")
	List <Pais> findBynumHabitantesBetween(int min, int max);
	
	//@Query("SELECT p FROM PAISSOS p")
	//List<Pais> getAll();
}

package com.Mario_Gago.gestioPaissos.backend.business.services;

import java.util.List;
import java.util.Optional;


import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;

public interface PaisServices {
	
	public Long create(Pais pais);
	
	public Optional<Pais> read (Long id);
	
	List<Pais> getAll();
	
	List<Pais> findBynumHabitantesBetween(int min, int max);
}

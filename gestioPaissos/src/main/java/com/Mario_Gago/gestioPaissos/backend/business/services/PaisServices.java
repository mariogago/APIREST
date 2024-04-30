package com.Mario_Gago.gestioPaissos.backend.business.services;

import java.util.List;
import java.util.Optional;
import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;

public interface PaisServices {

	Long create(Pais pais);	    // C
	
	Optional<Pais> read(Long id);   // R
	
	/**
	 * 
	 * Lanza una IllegalStateException si el código del producto es null o no existe en el sistema
	 * 
	 */
	void update(Pais producto);		// U
	
	/**
	 * Lanza una IllegalStateException si no existe la id en el sistema
	 * 
	 */
	void delete(Long id);				// D
	
	//List<Pais> getBetweenPriceRange(double min, double max);
	
	List<Pais> getAll();
	
}

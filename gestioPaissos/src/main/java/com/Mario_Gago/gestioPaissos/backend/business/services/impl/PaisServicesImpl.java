package com.Mario_Gago.gestioPaissos.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.Mario_Gago.gestioPaissos.backend.business.services.PaisServices;
import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;


@Service
public class PaisServicesImpl implements PaisServices {

	private final TreeMap<Long, Pais> PAISSOS = new TreeMap<>();
	
	public PaisServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Pais pais) {
		
		Long id = PAISSOS.lastKey() + 1;
		
		pais.setId(id);
		
		PAISSOS.put(pais.getId(), pais);
		
		return id;
	}

	@Override
	public Optional<Pais> read(Long id) {
		return Optional.ofNullable(PAISSOS.get(id));
	}
	
	

	@Override
	public List<Pais> getAll() {
		return new ArrayList<>(PAISSOS.values());
	}
	
	// ***************************************************************
	//
	// Private Methods
	//
	// ***************************************************************

	private void init() {
		
		Pais p1 = new Pais();
		Pais p2 = new Pais();
		
		p1.setId(10L);
		p1.setNombre("España");
		p1.setArea(506030);
		p1.setMoneda("Euros");
		p1.setNumHabitantes(48592909);
		
		p2.setId(11L);
		p2.setNombre("Alemania");
		p2.setArea(357592);
		p2.setMoneda("Euros");
		p2.setNumHabitantes(84358845);
		
		PAISSOS.put(p1.getId(), p1);
		PAISSOS.put(p2.getId(), p2);
		
	}


	public void update(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Long id) {
		
		if(id == null) {
			throw new IllegalStateException("No se puede actualizar un pais con código not null");
		}		

		if(!PAISSOS.containsKey(id)) {
			throw new IllegalStateException("El pais con código " + id + " no existe. No se puede actualizar.");
		}
		
		PAISSOS.remove(id);
		
	}
}

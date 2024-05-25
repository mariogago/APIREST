package com.Mario_Gago.gestioPaissos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Mario_Gago.gestioPaissos.backend.business.services.PaisServices;
import com.Mario_Gago.gestioPaissos.backend.repositories.PaisRepository;
import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;


@Service
public class PaisServicesImpl implements PaisServices {
	
	@Autowired
	private PaisRepository paisRepository;
	
	
	@Override
	@Transactional
	public Long create(Pais pais) {
		
		if(pais.getId() != null) {
			throw new IllegalStateException("NO SE PUEDE AGREGAR UN PAIS SIN ID");
		}
		
		Long id = System.currentTimeMillis();
		pais.setId(id);
		paisRepository.save(pais);
		return id;
	}
	
	@Override
	public Optional<Pais> read(Long id) {
		return paisRepository.findById(id);
	}

	@Override
	public List<Pais> getAll() {
		return paisRepository.findAll();
	}

	@Override
	public List<Pais> findBynumHabitantesBetween(int min, int max) {
		return paisRepository.findBynumHabitantesBetween(min, max);
	}
	
	
}

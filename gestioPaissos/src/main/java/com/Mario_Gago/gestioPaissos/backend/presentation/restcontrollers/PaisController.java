package com.Mario_Gago.gestioPaissos.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;
import com.Mario_Gago.gestioPaissos.backend.business.services.PaisServices;

@RestController
//@RequestMapping("/PAISSOS")
public class PaisController {

	@Autowired
	private PaisServices paisServices;
	
	@GetMapping
	public List<Pais> getAll(@RequestParam(name = "min", required = false)int min,
							 @RequestParam(name = "max", required = false)int max){
		
		List <Pais> paissos = null;
		
		if((min > 0 && min < max) && (max > 0 && max > min)) {
			paissos = paisServices.findBynumHabitantesBetween(min, max);
		}
		else {
			paissos = paisServices.getAll();
		}
		return paissos;
	}
	
}

package com.Mario_Gago.gestioPaissos.backend.presentation.restcontrollers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;
import com.Mario_Gago.gestioPaissos.backend.business.services.PaisServices;
import com.Mario_Gago.gestioPaissos.backend.presentation.config.*;

@RestController
//@RequestMapping("/paissos")
public class PaisController {

	@Autowired
	private PaisServices paisServices;
	
	@GetMapping("/paissos")
	public List<Pais> getAll(){
		return paisServices.getAll();
	}

	@GetMapping("/paissos/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		
		if(id > 500) {
			throw new RuntimeException("El número " + id + " no es válido.");
		}
		
		Optional<Pais> optional = paisServices.read(id);
		
		if (optional.isEmpty()) {
			RespuestaError respuestaError = new RespuestaError("No se encuentra el pais con id " + id);
			return new ResponseEntity<>(respuestaError, HttpStatus.NOT_FOUND);
	
		}
		
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping("/paissos")
	public ResponseEntity<?> create(@RequestBody Pais pais, UriComponentsBuilder ucb) {
		
		Long codigo = null;
		
		try {
			codigo = paisServices.create(pais);
		} catch(IllegalStateException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		URI uri = ucb.path("/paissos/{codigo}").build(codigo);
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/paissos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		try {
			paisServices.delete(id);
		} catch(IllegalStateException e) {
			throw new RuntimeException("No se encuentra el pais con id [" + id + "]. No se ha podido eliminar.");
		}
		
	}
	
	@PutMapping("/paissos")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Pais pais) {
		
		try {
			paisServices.update(pais);
		} catch(IllegalStateException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	
	// ****************************************************
	//
	// Gestión de excepciones
	//
	// ****************************************************
	
	@ExceptionHandler({IllegalArgumentException.class, ClassCastException.class})
	public ResponseEntity<?> gestor1(Exception e){
		return ResponseEntity.badRequest().body(new RespuestaError(e.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> gestor2(Exception e){
		return ResponseEntity.badRequest().body(new RespuestaError(e.getMessage()));
	}
	
}

package com.Mario_Gago.gestioPaissos.backend.presentation.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.Mario_Gago.gestioPaissos.backend.business.model.Pais;
import com.Mario_Gago.gestioPaissos.backend.business.services.PaisServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers=PaisController.class)
public class PaisControllerTest {

	private Pais pais1, pais2;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc miniPostman;
	
	@MockBean
	private PaisServices paisServices;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	
	private void initObjects() {
		pais1 = new Pais();
		pais1.setId(100L);
		pais1.setNombre("España");
		pais1.setMoneda("Euro");
		pais1.setArea(2000000);
		pais1.setNumHabitantes(1250000);
		
		pais2 = new Pais();
		pais2.setId(101L);
		pais2.setNombre("Japón");
		pais2.setMoneda("Yen");
		pais2.setArea(32000000);
		pais2.setNumHabitantes(4334500);
	}
	
	@Test
	void pedimos_todos_los_paises() throws Exception{
		//Arrange
		
		List<Pais> paissos = Arrays.asList(pais1, pais2);
		when(paisServices.getAll()).thenReturn(paissos);
		
		//Act
		
		MvcResult respuesta = 
				miniPostman.perform(get("/PAISSOS").contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn();
		
		String responseBody = 
				respuesta.getResponse().getContentAsString();
		
		String respuestaEsperada = objectMapper.writeValueAsString(paissos);
		
		//Assert
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(respuestaEsperada);
	}
}

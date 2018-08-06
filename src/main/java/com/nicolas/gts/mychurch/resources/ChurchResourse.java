package com.nicolas.gts.mychurch.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.gts.mychurch.domain.Church;

@RestController
@RequestMapping(value="/churches")
public class ChurchResourse {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Church> listChurches() {
		
	
		
		Church church1 = new Church(1,"Igreja o Brasil Para Cristo", "Terça: 19:30 - Culto de Oração; Domingo: 18:00 - Culto de Celebração","Igreja evangelica");
		Church church2 = new Church(2,"Igreja Metodista", "Terça: 19:30 - Culto de Ação de Graças; Domingo: 20:00 - Culto de Celebração","A Igreja Metodista cumpre a sua missão "
				+ "realizando o culto de Deus, pregando a Sua Palavra, ministrando os sacramentos, promovendo a fraternidade e a disciplina cristãs e proporcionando a seus membros meios "
				+ "para alcançarem uma experiência cristã progressiva, visando ao desempenho de seu testemunho e serviço no mundo.");
		
		List<Church> listOfChurchs =  new ArrayList<>();
		listOfChurchs.add(church1);
		listOfChurchs.add(church2);
		
		return listOfChurchs;
	}

}
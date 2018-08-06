package com.nicolas.gts.mychurch;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;

@SpringBootApplication
public class MychurchApplication implements CommandLineRunner {

	@Autowired
	private ChurchRepository churchRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MychurchApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Church church1 = new Church(null,"Igreja o Brasil Para Cristo", "Terça: 19:30 - Culto de Oração; Domingo: 18:00 - Culto de Celebração","Igreja evangelica");
		Church church2 = new Church(null,"Igreja Metodista", "Terça: 19:30 - Culto de Ação de Graças; Domingo: 20:00 - Culto de Celebração","A Igreja Metodista cumpre a sua missão "
				+ "realizando o culto de Deus, pregando a Sua Palavra, ministrando os sacramentos, promovendo a fraternidade e a disciplina cristãs e proporcionando a seus membros meios "
				+ "para alcançarem uma experiência cristã progressiva, visando ao desempenho de seu testemunho e serviço no mundo.");
		
	
 		churchRepository.saveAll(Arrays.asList(church1, church2));
	}
}

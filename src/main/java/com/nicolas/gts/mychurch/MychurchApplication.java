package com.nicolas.gts.mychurch;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.City;
import com.nicolas.gts.mychurch.domain.State;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.repositories.CityRepository;
import com.nicolas.gts.mychurch.repositories.PostRepository;
import com.nicolas.gts.mychurch.repositories.StateRepository;

@SpringBootApplication
public class MychurchApplication implements CommandLineRunner {

	@Autowired
	private ChurchRepository churchRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MychurchApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Church church1 = new Church(null,"0909992929-29","Igreja o Brasil Para Cristo","Igreja evangelica");
		Church church2 = new Church(null,"0902929388-21","Igreja Metodista","A Igreja Metodista cumpre a sua missão "
				+ "realizando o culto de Deus, pregando a Sua Palavra, ministrando os sacramentos, promovendo a fraternidade e a disciplina cristãs e proporcionando a seus membros meios "
				+ "para alcançarem uma experiência cristã progressiva, visando ao desempenho de seu testemunho e serviço no mundo.");
		
	
 		churchRepository.saveAll(Arrays.asList(church1, church2));
 		
 		
		State state1 = new State(null, "Paraíba");
		State state2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Campina Grande",state1);
		City c2 = new City(null, "São Paulo",state2);
		City c3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(c1));
		state2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		
		

	}
}

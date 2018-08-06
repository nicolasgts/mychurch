package com.nicolas.gts.mychurch;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.City;
import com.nicolas.gts.mychurch.domain.PostArticle;
import com.nicolas.gts.mychurch.domain.PostEvent;
import com.nicolas.gts.mychurch.domain.State;
import com.nicolas.gts.mychurch.repositories.AdressRepository;
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
	
	@Autowired
	private AdressRepository adressRepository;
	
	
	
	
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
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Adress ad1 = new Adress(null,"Rua Idenfonso Aires","204A","casa","Prata",c1,"58400000",church1);
		Adress ad2 = new Adress(null,"Av. Barão do Rio Branco","302","apartamento","Centro",c2,"5837377",church2);
		
		adressRepository.saveAll(Arrays.asList(ad1, ad2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PostEvent pte1 = new PostEvent(null, "Culto de Oração", "",church1, sdf.parse("15/08/2018 19:30"),  sdf.parse("15/08/2018 21:30"));
		PostEvent pte2 = new PostEvent(null, "Culto Matinal", "",church1, sdf.parse("13/08/2018 06:30"),  sdf.parse("15/08/2018 08:30"));
		PostArticle pta1 = new PostArticle(null, "Os principios da biblia","Artigo sobre a pregação do culto de oração", church2, "resumo", "desconhecido",sdf.parse("18/08/2018 10:00"));
		PostEvent pte3 = new PostEvent(null, "Culto Matinal", "",church2, sdf.parse("13/08/2018 06:30"),  sdf.parse("15/08/2018 08:30"));
		
		
		postRepository.saveAll(Arrays.asList(pte1, pta1,pte2,pte3));
		
		
	}
}

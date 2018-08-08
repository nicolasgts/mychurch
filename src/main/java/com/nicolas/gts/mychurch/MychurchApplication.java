package com.nicolas.gts.mychurch;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.City;
import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.domain.State;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.domain.enums.Profile;
import com.nicolas.gts.mychurch.repositories.AdressRepository;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.repositories.CityRepository;
import com.nicolas.gts.mychurch.repositories.PostRepository;
import com.nicolas.gts.mychurch.repositories.StateRepository;
import com.nicolas.gts.mychurch.repositories.UserRepository;

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
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MychurchApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Church church1 = new Church(null,"44.877.055/0001-50","Igreja o Brasil Para Cristo","Igreja evangelica");
		Church church2 = new Church(null,"15.123.280/0001-00","Igreja Metodista","A Igreja Metodista cumpre a sua missão "
				+ "realizando o culto de Deus, pregando a Sua Palavra, ministrando os sacramentos, promovendo a fraternidade e a disciplina cristãs e proporcionando a seus membros meios "
				+ "para alcançarem uma experiência cristã progressiva, visando ao desempenho de seu testemunho e serviço no mundo.");
		

		churchRepository.saveAll(Arrays.asList(church1, church2));
		
		User user1 = new User(null, "Nicolas", "nicolas@email.com",pe.encode("123456") , "082.945.970-74", church1);
		User user2 = new User(null, "Fulano", "fulano@email.com",pe.encode("123456") , "448.265.770-01", church2);
		user1.addProfile(Profile.ADMIN);
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		
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
		
		Post pt1 = new Post(null, "Culto Matinal", "show", church1);
		Post pt2 = new Post(null, "Culto de Oração", "show3", church1);
		Post pt3 = new Post(null, "Culto dos Jovens", "show4", church2);
		Post pt4 = new Post(null, "UHULL", "massa", church2);
	
		
		postRepository.saveAll(Arrays.asList(pt1, pt2,pt3,pt4));
	
 		
		
		
	}
}

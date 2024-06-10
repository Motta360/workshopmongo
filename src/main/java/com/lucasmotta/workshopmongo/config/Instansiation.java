package com.lucasmotta.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasmotta.workshopmongo.domain.Post;
import com.lucasmotta.workshopmongo.domain.User;
import com.lucasmotta.workshopmongo.dto.AuthorDTO;
import com.lucasmotta.workshopmongo.repositories.PostRepository;
import com.lucasmotta.workshopmongo.repositories.UserRepository;

@Configuration
public class Instansiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, LocalDate.parse("21/03/2018", fmt),"Partiu viagem", "Vou viajar para são Paulo",new AuthorDTO(maria));
		Post p2 = new Post(null, LocalDate.parse("23/03/2018", fmt),"Bom dia", "Acordei Feliz hoje",new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(p1,p2));
	}

}

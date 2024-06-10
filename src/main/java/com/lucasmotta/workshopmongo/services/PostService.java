package com.lucasmotta.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmotta.workshopmongo.domain.Post;
import com.lucasmotta.workshopmongo.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository userRepository;



	public Post findById(String id) {
		Optional<Post> obj = userRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String text){
		return userRepository.findByTitleContainingIgnoreCase(text);
		
		
	}



}

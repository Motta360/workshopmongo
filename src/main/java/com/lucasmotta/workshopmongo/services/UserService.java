package com.lucasmotta.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmotta.workshopmongo.domain.User;
import com.lucasmotta.workshopmongo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		
		List<User> lista = userRepository.findAll();
		return lista;
	
	}

}

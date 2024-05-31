package com.lucasmotta.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmotta.workshopmongo.domain.User;
import com.lucasmotta.workshopmongo.dto.UserDTO;
import com.lucasmotta.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> lista = userService.findAll();
		List<UserDTO> lista2 = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(lista2);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO user = new UserDTO(userService.finById(id));
		return ResponseEntity.ok().body(user);		
	}

}

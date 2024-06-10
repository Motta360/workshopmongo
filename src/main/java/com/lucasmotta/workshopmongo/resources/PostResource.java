package com.lucasmotta.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasmotta.workshopmongo.domain.Post;
import com.lucasmotta.workshopmongo.domain.User;
import com.lucasmotta.workshopmongo.dto.UserDTO;
import com.lucasmotta.workshopmongo.services.PostService;
import com.lucasmotta.workshopmongo.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/users")
public class PostResource {
	@Autowired
	private PostService userService;


	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}


}

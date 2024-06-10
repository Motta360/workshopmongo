package com.lucasmotta.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmotta.workshopmongo.domain.Post;
import com.lucasmotta.workshopmongo.resources.util.URL;
import com.lucasmotta.workshopmongo.services.PostService;


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
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = userService.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}


}
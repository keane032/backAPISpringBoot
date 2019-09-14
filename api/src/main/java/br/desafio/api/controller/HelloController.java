package br.desafio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.desafio.api.model.User;
import br.desafio.api.service.UserService;

@RestController
public class HelloController {

	@Autowired
	UserService service;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/user")
	private ResponseEntity<String> cadastrarUsuario(@RequestBody User user ){
		if (service.createUser(user) != null) { 
			return new ResponseEntity<String>("",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("error",HttpStatus.EXPECTATION_FAILED);
	}
}

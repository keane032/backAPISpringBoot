package br.desafio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.desafio.api.model.Quarto;
import br.desafio.api.service.QuartoService;

@RestController
public class QuartoController {

	@Autowired
	QuartoService service;
	
	@PostMapping("/quarto")
	public ResponseEntity<String> save(@RequestBody Quarto quarto){
		if (service.create(quarto) != null) { 
			return new ResponseEntity<String>("",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("error",HttpStatus.EXPECTATION_FAILED);
	}
	
	 @PutMapping("/quarto")
	 public ResponseEntity<Quarto> update(@RequestBody Quarto quarto) {
		   Quarto newQuarto = service.update(quarto);
	       return new ResponseEntity<>(newQuarto,HttpStatus.CREATED);
	 }
}

package br.desafio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.api.model.Quarto;
import br.desafio.api.repositiry.QuartoRepository;

@Service
public class QuartoService {
	
	@Autowired
	QuartoRepository repository;

	public Quarto create(Quarto quarto) {
		return repository.save(quarto);
	}
	
	public Quarto update(Quarto quarto) {
		Quarto oldQuarto = repository.getOne(quarto.getId());
		oldQuarto.setNumero(quarto.getNumero());
		return repository.save(oldQuarto);
	}
	
}

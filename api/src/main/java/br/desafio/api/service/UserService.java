package br.desafio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.api.model.User;
import br.desafio.api.repositiry.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User createUser(User user) {
		User user2 = repository.save(user);
		System.out.println(user2.getLogin());
		return user2;
	}
	
}

package br.desafio.api.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.api.model.User;
@Repository
public interface UserRepository extends  JpaRepository<User, Integer> {

}


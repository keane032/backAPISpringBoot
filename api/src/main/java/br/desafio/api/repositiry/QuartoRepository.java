package br.desafio.api.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.api.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

}

package br.desafio.api.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.api.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}

package br.desafio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.desafio.api.model.Hotel;
import br.desafio.api.repositiry.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository repository;
	
	public Hotel createHotel(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public Hotel getOne(Integer id) {
		Hotel hotel = repository.getOne(id);		
		System.out.println(hotel.getNome());
		return hotel;
	}
	
	public Hotel update(Hotel hotel) {
		Hotel oldhotel = repository.getOne(hotel.getId());
		oldhotel.setNome(hotel.getNome());
		oldhotel.setQuartos(hotel.getQuartos());
		return repository.save(oldhotel);
	}
	
	public Page<Hotel> findAll(Integer newpage){
		  int page = newpage;
	        int size = 10;
	        PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "id");
	        return repository.findAll(pageRequest); 
	    
	    }
	}


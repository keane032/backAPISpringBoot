package br.desafio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.desafio.api.model.Hotel;
import br.desafio.api.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@PostMapping("/hotel")
	private ResponseEntity<String> cadastrarUsuario(@RequestBody Hotel hotel ){
		
		if (service.createHotel(hotel) != null) { 
			return new ResponseEntity<String>("",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("error",HttpStatus.EXPECTATION_FAILED);
	}
	
   @GetMapping("/hotel/all")
    public Page<Hotel> getAll(@RequestParam Integer page) {
        return service.findAll(page);
    }
   
   @PutMapping("/hotel")
   public ResponseEntity<Hotel> update(@RequestBody Hotel hotel) {
	   Hotel newHotel = service.update(hotel);
       return new ResponseEntity<>(newHotel,HttpStatus.CREATED);
   }
   
   @GetMapping("/hotel/{id}")
   public ResponseEntity<Hotel> getOne(@PathVariable Integer id) {
	   Hotel hotel = service.getOne(id);
	   System.out.println(hotel.getNome());
       return new ResponseEntity<>(hotel,HttpStatus.CREATED);
   }

}

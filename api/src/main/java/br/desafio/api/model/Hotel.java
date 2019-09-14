package br.desafio.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="hotel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@OneToMany
	private List<Quarto> quartos;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Quarto> getQuartos(){
		return quartos;
	}
	
	public void setQuartos(List<Quarto> newQuartos){
		this.quartos = newQuartos;
	}
	
}

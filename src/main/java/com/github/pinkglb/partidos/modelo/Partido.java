package com.github.pinkglb.partidos.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDateTime dataFundacao = LocalDateTime.now();
	@OneToMany(mappedBy = "nome")
	private List<Associado> associados = new ArrayList<>();
	
	public Partido() {
		
	}
	
	public Partido(String nome, String sigla, String ideologia) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getIdeologia() {
		return ideologia;
	}
	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}
	public LocalDateTime getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDateTime dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public Long getId() {
		return id;
	}
}

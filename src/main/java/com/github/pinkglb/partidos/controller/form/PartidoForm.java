package com.github.pinkglb.partidos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.github.pinkglb.partidos.modelo.Partido;

public class PartidoForm {
	
	@NotEmpty @NotNull
	private String nome;
	@NotEmpty @NotNull
	private String sigla;
	@NotEmpty @NotNull @Pattern(regexp = "//|Centro|Direita|Esquerda|/g")
	private String ideologia;
	
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
	public Partido converter() {
		return new Partido(nome, sigla, ideologia);
	}
	
	
}

package com.github.pinkglb.partidos.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pinkglb.partidos.modelo.Associado;
import com.github.pinkglb.partidos.modelo.Partido;

public class PartidoDto {
	
	private String nome;
	private String sigla;
	private String ideologia;
	private LocalDateTime dataFundacao;
	
	
	
	public PartidoDto(Partido partido) {
		
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.ideologia = partido.getIdeologia();
		this.dataFundacao = partido.getDataFundacao();
	}
	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
	public String getIdeologia() {
		return ideologia;
	}
	public LocalDateTime getDataFundacao() {
		return dataFundacao;
	}
	public static List<PartidoDto> converter(List<Partido> partidos) {
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
	}
}

package com.github.pinkglb.partidos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.github.pinkglb.partidos.modelo.Associado;

public class AssociadoDto {
	private String nome;
	private String cargoPolitico;
	private String dataNascimento;
	private String sexo;
	
	public AssociadoDto(Associado associado) {
		this.nome = associado.getNome();
		this.cargoPolitico = associado.getCargoPolitico();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
	}

	public String getNome() {
		return nome;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public static List<AssociadoDto> converter(List<Associado> associados) {
		return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());
	}
	
}

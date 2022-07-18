package com.github.pinkglb.partidos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.github.pinkglb.partidos.modelo.Associado;

public class AssociadoForm {
	
	@NotEmpty @NotNull
	private String nome;
	@NotEmpty @NotNull
	private String cargoPolitico;
	@NotEmpty @NotNull
	private String dataNascimento;
	@NotEmpty @NotNull @Pattern(regexp = "//|Masculino|Feminino|/g")
	private String sexo;
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCargoPolitico() {
		return cargoPolitico;
	}



	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}



	public String getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Associado converter() {
		return new Associado(nome, cargoPolitico, dataNascimento, sexo);
	}

}

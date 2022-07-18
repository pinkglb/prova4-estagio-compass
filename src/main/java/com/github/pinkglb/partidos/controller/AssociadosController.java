package com.github.pinkglb.partidos.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.pinkglb.partidos.controller.dto.AssociadoDto;
import com.github.pinkglb.partidos.controller.dto.PartidoDto;
import com.github.pinkglb.partidos.controller.form.AssociadoForm;
import com.github.pinkglb.partidos.modelo.Associado;
import com.github.pinkglb.partidos.modelo.Partido;
import com.github.pinkglb.partidos.repository.AssociadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadosController {
	
		@Autowired
		private AssociadoRepository associadoRepository;
		
		@GetMapping
		@Transactional
		public List<AssociadoDto> lista() {
			List<Associado> associados = associadoRepository.findAll();
			
			return AssociadoDto.converter(associados);
	}
		@PostMapping
		@Transactional
		public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder) {
			Associado associado = form.converter();
			associadoRepository.save(associado);
			
			URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
			return ResponseEntity.created(uri).body(new AssociadoDto(associado));
		}
		
		@GetMapping("/{id}")
		@Transactional
		public ResponseEntity<AssociadoDto> detalhar(@PathVariable Long id) {
			Optional<Associado> associado = associadoRepository.findById(id);
			if(associado.isPresent()) {
				return ResponseEntity.ok(new AssociadoDto(associado.get()));
			}
			return ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<AssociadoDto> remover(@PathVariable Long id){
			Optional<Associado> optional = associadoRepository.findById(id);
			if(optional.isPresent()) {
				associadoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}
}

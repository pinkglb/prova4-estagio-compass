package com.github.pinkglb.partidos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.pinkglb.partidos.controller.dto.PartidoDto;
import com.github.pinkglb.partidos.controller.form.AtualizacaoPartidoForm;
import com.github.pinkglb.partidos.controller.form.PartidoForm;
import com.github.pinkglb.partidos.modelo.Partido;
import com.github.pinkglb.partidos.repository.PartidoRepository;

@RestController
@RequestMapping("/partidos")
public class PartidosController {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@GetMapping
	@Transactional
	public List<PartidoDto> lista(String ideologia) {
		System.out.println(ideologia);
		if (ideologia != null) {
			List<Partido> partidos = partidoRepository.findByIdeologia(ideologia);
			return PartidoDto.converter(partidos);
		}else {
			List<Partido> partidos = partidoRepository.findAll();
			return PartidoDto.converter(partidos);
		}
	}
	@PostMapping
	@Transactional
	public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder) {
		Partido partido = form.converter();
		partidoRepository.save(partido);
		
		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PartidoDto(partido));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> detalhar(@PathVariable Long id) {
		Optional<Partido> partido = partidoRepository.findById(id);
		if(partido.isPresent()) {
			return ResponseEntity.ok(new PartidoDto(partido.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPartidoForm form){
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			Partido partido = form.atualizar(id, partidoRepository);
			return ResponseEntity.ok(new PartidoDto(partido));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> remover(@PathVariable Long id){
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			partidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

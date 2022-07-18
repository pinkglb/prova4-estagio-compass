package com.github.pinkglb.partidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pinkglb.partidos.modelo.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

	List<Partido> findByIdeologia(String ideologia);

	
}

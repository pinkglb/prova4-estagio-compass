package com.github.pinkglb.partidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pinkglb.partidos.modelo.Associado;
import com.github.pinkglb.partidos.modelo.Partido;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}

package com.accenture.academico.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academico.model.entities.Extrato;

public interface TransferenciaRepository extends JpaRepository<Extrato, Long>{

}

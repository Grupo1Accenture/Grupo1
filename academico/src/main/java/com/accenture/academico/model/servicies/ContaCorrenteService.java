package com.accenture.academico.model.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.ContaCorrente;
import com.accenture.academico.model.repositories.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository repository; 
	
	public List<ContaCorrente>findAll(){
		return repository.findAll();
	}
	public ContaCorrente findById(Long id) {
		Optional<ContaCorrente> obj = repository.findById(id);
		return obj.get();
	}
}

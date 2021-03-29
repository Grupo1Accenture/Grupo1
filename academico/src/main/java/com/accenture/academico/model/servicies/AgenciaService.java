package com.accenture.academico.model.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.Agencia;
import com.accenture.academico.model.repositories.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository repository; 
	
	public List<Agencia>findAll(){
		return repository.findAll();
	}
	public Agencia findById(Long id) {
		Optional<Agencia> obj = repository.findById(id);
		return obj.get();
	}
}

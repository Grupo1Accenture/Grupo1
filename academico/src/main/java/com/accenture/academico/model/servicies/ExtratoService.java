package com.accenture.academico.model.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.Extrato;
import com.accenture.academico.model.repositories.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	private ExtratoRepository repository; 
	
	public List<Extrato>findAll(){
		return repository.findAll();
	}
	public Extrato findById(Long id) {
		Optional<Extrato> obj = repository.findById(id);
		return obj.get();
	}
}

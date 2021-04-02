package com.accenture.academico.model.servicies;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.Extrato;
import com.accenture.academico.model.repositories.ExtratoRepository;
import com.accenture.academico.model.servicies.exceptions.DatabaseException;
import com.accenture.academico.model.servicies.exceptions.ResourceNotFoundException;

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
	public Extrato insert(Extrato obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public Extrato update(Long id,Extrato obj ) {
		try {
			Extrato entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(Extrato entity, Extrato obj) {
		entity.setDataHoraMovimento(Instant.now());
		entity.setValorOperacao(obj.getValorOperacao());
		
		
		
	}
}

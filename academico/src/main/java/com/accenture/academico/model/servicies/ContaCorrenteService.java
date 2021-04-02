package com.accenture.academico.model.servicies;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.ContaCorrente;
import com.accenture.academico.model.repositories.ContaCorrenteRepository;
import com.accenture.academico.model.servicies.exceptions.DatabaseException;
import com.accenture.academico.model.servicies.exceptions.ResourceNotFoundException;

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
	public ContaCorrente insert(ContaCorrente obj) {
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
	public ContaCorrente update(Long id,ContaCorrente obj ) {
		try {
			ContaCorrente entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(ContaCorrente entity, ContaCorrente obj) {
		entity.setContaCorrenteNumero(obj.getContaCorrenteNumero());
		entity.setSaldo(obj.getSaldo());
		
	}
}

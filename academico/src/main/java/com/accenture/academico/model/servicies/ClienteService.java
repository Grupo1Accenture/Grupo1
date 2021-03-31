package com.accenture.academico.model.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.entities.Cliente;
import com.accenture.academico.model.repositories.ClienteRepository;
import com.accenture.academico.model.servicies.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository; 
	
	public List<Cliente>findAll(){
		return repository.findAll();
	}
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Cliente update(Long id,Cliente obj ) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	private void updateData(Cliente entity, Cliente obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		entity.setPhone(obj.getPhone());
		
	}
}

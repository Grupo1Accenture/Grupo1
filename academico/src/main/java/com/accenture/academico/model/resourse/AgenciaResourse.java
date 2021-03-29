package com.accenture.academico.model.resourse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.entities.Agencia;
import com.accenture.academico.model.servicies.AgenciaService;

@RestController
@RequestMapping(value= "/agencias")
public class AgenciaResourse {
	@Autowired
	private AgenciaService service;
	
	@GetMapping
	public ResponseEntity<List<Agencia>> findAll(){
		List<Agencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agencia> findById(@PathVariable Long id){
		Agencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

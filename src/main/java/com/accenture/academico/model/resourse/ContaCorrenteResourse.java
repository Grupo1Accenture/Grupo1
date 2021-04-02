package com.accenture.academico.model.resourse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.entities.ContaCorrente;
import com.accenture.academico.model.servicies.ContaCorrenteService;

@RestController
@RequestMapping(value= "/contacorrente")
public class ContaCorrenteResourse {
	@Autowired
	private ContaCorrenteService service;
	
	@GetMapping
	public ResponseEntity<List<ContaCorrente>> findAll(){
		List<ContaCorrente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaCorrente> findById(@PathVariable Long id){
		ContaCorrente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

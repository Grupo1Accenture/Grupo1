package com.accenture.academico.model.resourse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.entities.Extrato;
import com.accenture.academico.model.servicies.ExtratoService;

@RestController
@RequestMapping(value= "/extratos")
public class ExtratoResourse {
	@Autowired
	private ExtratoService service;
	
	@GetMapping
	public ResponseEntity<List<Extrato>> findAll(){
		List<Extrato> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Extrato> findById(@PathVariable Long id){
		Extrato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

package com.accenture.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.accenture.academy.entity.Agencia;
import com.accenture.academy.service.AgenciaService;

@RestController
@RequestMapping("/sistema")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
	@PutMapping("/Cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	 public void Agencia(@PathVariable Long id, @RequestBody Agencia agencia){
      this.agenciaService.atualizarAgencia(id, agencia);
    }

}
package com.accenture.academico.model.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_transferencia")
public class Transferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHoraMovimento;
	
	@OneToOne
	@JoinColumn(name = "saldo_id")
	private double saldo;
	
	@OneToOne
	@JoinColumn(name = "valor_id")
	private double valor;
	
	
	@OneToMany
	@JoinColumn(name = "conta_id")
	private Cliente conta;
	
	@ManyToOne
	@JoinColumn(name = "contaDestino_id")
	private Cliente contaDestino;

public Transferencia() {
	
}


public Transferencia(Long id, Instant dataHoraMovimento, double saldo, double valor, Cliente conta, Cliente contaDestino) {
	super();
	this.id = id;
	this.dataHoraMovimento = dataHoraMovimento;
	this.saldo = saldo;
	this.valor = valor;	
	this.conta = conta;
	this.contaDestino = contaDestino;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public Long getId() {
	return id;
}

public Double getSaldo() {
	return saldo;
}
public Instant getDataHoraMovimento() {
	return dataHoraMovimento;
}

public Double getValorOperacao() {
	return valor;
}
public void setValorOPeracao(double valorOperacao) {
	this.valor = valorOperacao;
	
}
public Cliente getConta() {
	return conta;
}

public Cliente getContaDestino() {
	return contaDestino;
}

public void setContaDestino (Cliente contaDestino) {
	this.contaDestino = contaDestino;
}


public void debito(double valor) {
	if(valor<this.saldo) {
		saldo-=valor;
	}else {
		System.out.println("NEGADO"); //provisorio
	}

}


public boolean contaExiste(boolean contaDestino) {
	if (contaDestino == true) {
	return contaDestino;
	}
	return false;
}
public void transfencia(double valor,Cliente ContaDestino) {
	 if (this.saldo < valor) {
           this.debito(valor);
           ContaDestino.credito(valor); // TEXTO2 
       }else{
       	System.out.println("Saldo insuficiente"); //provisorio
}
}
}
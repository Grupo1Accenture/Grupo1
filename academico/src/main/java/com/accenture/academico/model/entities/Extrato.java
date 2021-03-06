package com.accenture.academico.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_extrato")
public class Extrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHoraMovimento;
	
	private Double valorOperacao;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Cliente conta;
	
	public Extrato() {
	}

	public Extrato(Long id, Instant dataHoraMovimento, double valorOperacao, Cliente conta) {
		super();
		this.id = id;
		this.dataHoraMovimento = dataHoraMovimento;
		this.valorOperacao = valorOperacao;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(Instant dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Cliente getConta() {
		return conta;
	}

	public void setConta(Cliente conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extrato other = (Extrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 @Enumerated(EnumType.STRING)
	 @Column(name = "OperacoesBancarias")
	    private OperacoesBancarias operacoesBancarias;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id_extratos")
	    private List<Extrato> extratos;
}


package com.accenture.academy.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O Nome nao pode ser nulo")
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "telefone")
    private String telefone;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contaCorente")
    private List<ContaCorrente> contaCorrente;
    @JoinColumn(name = "id_agencia")
    private List<Agencia> agencia;

}
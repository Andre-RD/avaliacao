package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "TB_INSTRUTOR")
@Data
public class InstrutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSTRUTOR")
    private Long idInstrutor;

    @Column(name = "DS_INSTRUTOR")
    private String nomeInstrutor;

    @Column(name = "VL_HORA")
    private Double valorHora;

}

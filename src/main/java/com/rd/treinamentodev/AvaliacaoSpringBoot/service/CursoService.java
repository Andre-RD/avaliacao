package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public CursoEntity gravar(CursoDTO cursoDTO){
        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setNomeCurso(cursoDTO.getNome());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());

        return repository.save(cursoEntity);
    }

    public List<CursoEntity> buscarPorNome(String nome){
        return repository.findByNomeCurso(nome);
    }


}

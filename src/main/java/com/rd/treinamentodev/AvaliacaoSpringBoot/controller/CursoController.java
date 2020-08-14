package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping("/curso")
    public ResponseEntity buscarPorNome(String nome){
        return ResponseEntity.ok().body(service.buscarPorNome(nome));
    }

    @PostMapping("/curso")
    public ResponseEntity gravar(@RequestBody CursoDTO cursoDTO){

        ResultData resultData = null;

        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                CursoEntity cursoEntity = service.gravar(cursoDTO);
                resultData = new ResultData<CursoEntity>(HttpStatus.OK.value(), "Curso registrada com sucesso!", cursoEntity);
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            }catch(Exception e){
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar o Curso", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }

}

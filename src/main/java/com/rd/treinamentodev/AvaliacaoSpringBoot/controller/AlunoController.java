package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/aluno")
    public ResponseEntity gravar(@RequestBody AlunoDTO alunoDTO){
        ResultData resultData = null;


        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                ResponseEntity alunoEntity = alunoService.gravar(alunoDTO);
                resultData = new ResultData<ResponseEntity>(HttpStatus.OK.value(),"Aluno registrado com sucesso!", alunoEntity);
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            }catch(Exception e){
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao o aluno", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }

}

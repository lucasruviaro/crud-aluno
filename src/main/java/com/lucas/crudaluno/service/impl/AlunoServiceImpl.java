package com.lucas.crudaluno.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucas.crudaluno.entidade.Aluno;
import com.lucas.crudaluno.repository.AlunoRepository;
import com.lucas.crudaluno.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

    
    private AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);

    }

    @Override
    public Aluno getAlunobyId(Long id) {
       return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno editarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void excluirAluno(Long id) {
        alunoRepository.deleteById(id);
        
    }



} 
  


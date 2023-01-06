package com.lucas.crudaluno.service;

import java.util.List;

import com.lucas.crudaluno.entidade.Aluno;

    public interface AlunoService {
    
        List<Aluno> listarTodos();
    
        Aluno salvarAluno(Aluno aluno);

        Aluno getAlunobyId(Long id);

        Aluno editarAluno(Aluno aluno);

        void excluirAluno(Long id);
    }


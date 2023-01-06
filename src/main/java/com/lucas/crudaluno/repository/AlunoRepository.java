package com.lucas.crudaluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.crudaluno.entidade.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}


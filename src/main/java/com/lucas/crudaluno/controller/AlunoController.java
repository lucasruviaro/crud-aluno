package com.lucas.crudaluno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucas.crudaluno.entidade.Aluno;
import com.lucas.crudaluno.service.AlunoService;

@Controller
public class AlunoController {
    
    public AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping(value = "/alunos")
    public String listarEstudantes(Model model){
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos.html";
    }

    @GetMapping(value = "/alunos/novo")
    public String cadastroEstudante(Model model){
        Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "criaraluno.html";
    }

    @PostMapping(value = "/alunos")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno){
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    @GetMapping(value = "/alunos/editar/{id}")
    public String editarAluno(@PathVariable Long id, Model model){
        model.addAttribute("aluno", alunoService.getAlunobyId(id));
        return "editaraluno.html";
    }

    @PostMapping("/alunos/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("aluno") Aluno aluno,
			Model model) {
		
		Aluno alunoExistente = alunoService.getAlunobyId(id);
		alunoExistente.setId(id);
		alunoExistente.setNome(aluno.getNome());
		alunoExistente.setSobrenome(aluno.getSobrenome());
		alunoExistente.setEmail(aluno.getEmail());
		
		alunoService.editarAluno(alunoExistente);
		return "redirect:/alunos";		
	}

    @GetMapping("/alunos/{id}")
    public String excluirAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
        return "redirect:/alunos";
    }

}

package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Funcionario;
import com.example.demo.services.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioservice;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioservice) {
		this.funcionarioservice = funcionarioservice;
	}

	@PostMapping("/criar")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario funcionariosalvo = funcionarioservice.salvarFuncionario(funcionario);
		if(funcionariosalvo != null) {
			return ResponseEntity.ok(funcionariosalvo);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public List<Funcionario> buscarTodos() {
		return funcionarioservice.buscarTodosFuncionario();
		}

	@GetMapping("/{id}")
	public Funcionario buscarPorId(@PathVariable Long id) {
		return funcionarioservice.buscarFuncionarioPorId(id);
	}


}

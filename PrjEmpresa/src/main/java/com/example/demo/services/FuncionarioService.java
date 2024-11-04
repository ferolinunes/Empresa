package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Departamento;
import com.example.demo.entities.Funcionario;
import com.example.demo.repositories.DepartamentoRepository;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionariorepository;
    private final DepartamentoRepository departamentorepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionariorepository, DepartamentoRepository departamentorepository) {
		this.funcionariorepository = funcionariorepository;
		this.departamentorepository = departamentorepository;
	}

	public Funcionario salvarFuncionario(Funcionario funcionario) {
		if(funcionario.getDepartamento() !=null && funcionario.getDepartamento().getId() !=null ) {
			Optional<Departamento> departamento = departamentorepository.findById(funcionario.getDepartamento().getId()); //variavel fornecedor que vai localizar o fornecedor
			if(departamento.isPresent()) {
				funcionario.setDepartamento(departamento.get());
				return funcionariorepository.save(funcionario);
			} else {
				throw new RuntimeException("Departamento não encontrado");  //uma exceção
			}
		} else {
			throw new RuntimeException("ID do Departamento é obrigatório");
		}
	}

	public Funcionario buscarFuncionarioPorId(Long id) {
		return funcionariorepository.findById(id).orElse(null);
	}

	public List<Funcionario> buscarTodosFuncionario() {
		return funcionariorepository.findAll();
	}
	
}


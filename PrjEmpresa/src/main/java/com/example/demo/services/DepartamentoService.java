package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Departamento;
import com.example.demo.repositories.DepartamentoRepository;


@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentorepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentorepository) {
		this.departamentorepository = departamentorepository;
	}

	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentorepository.save(departamento);
	}

	public Departamento buscarDepartamentoPorId(Long id) {
		return departamentorepository.findById(id).orElse(null);
	}

	public List<Departamento> buscarTodosUsuarios() {
		return departamentorepository.findAll();
	}
}

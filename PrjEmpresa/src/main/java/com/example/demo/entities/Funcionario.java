package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String funnome;
    private String funnascimento;
    private String funsalario;

    public Long getId() {
    return id;
    }
    public void setId(Long id) {
    this.id = id;
    }
    
    @OneToOne 
	@JoinColumn(name = "departamento_id") 
	private Departamento departamento;
    
    
	public String getFunnome() {
		return funnome;
	}
	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}
	
	public String getFunnascimento() {
		return funnascimento;
	}
	public void setFunnascimento(String funnascimento) {
		this.funnascimento = funnascimento;
	}
	
	public String getFunsalario() {
		return funsalario;
	}
	public void setFunsalario(String funsalario) {
		this.funsalario = funsalario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}	
}

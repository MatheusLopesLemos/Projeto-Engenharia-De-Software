package model.dao;

import java.util.HashSet;
import java.util.Set;

import model.Aluno;

public class DaoAluno2{
	
	private static Set<Aluno> conjAlunos = new HashSet<Aluno>();
	
	public DaoAluno2() {
		
	}
	
	public boolean adicionar(Aluno a) {
		return conjAlunos.add(a);
	}
	
	public boolean alterar(Aluno a) {
		return conjAlunos.add(a);
	}
	
	public boolean remover(Aluno a) {
		return conjAlunos.remove(a);
	}
	
	public Aluno consultar(String cpf) {
		for(Aluno a : conjAlunos)
			if(a.getCpf() == cpf)
				return a;
		return null;
		
	}
	
	public Aluno[] consultarTodos() {
		int numElementos = conjAlunos.size();
		Aluno[] array = new Aluno[numElementos];
		int i = 0;
		for(Aluno a : conjAlunos)
			array[i++] = a;
		return array;
	}

}

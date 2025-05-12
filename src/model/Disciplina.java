package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Disciplina {

	final private static int TAM_NOME = 40;

	@Id
	@GeneratedValue
	private int id_disciplina;
	@Column(length = TAM_NOME)
	private String nome;
	@Column
	private int numCreditos;
	@Column
	private int cargaHoraria;
	@OneToMany(mappedBy="disciplina") //--> mappedBy indica qual é o nome do atributo unário presente na outra classe
	private Set<Turma> conjTurmas;

	public Disciplina() {

	}

	public Disciplina(String n, int nc, int c) throws ModelException {
		super();
		this.setNome(n);
		this.setNumCreditos(nc);
		this.setCargaHoraria(c);
		this.setConjTurmas(new HashSet<Turma>());
	}
	
	public int getId_disciplina() {
		return this.id_disciplina;
	}

	public Set<Turma> getConjTurmas() {
		return new HashSet<Turma>(this.conjTurmas);
	}

	public void setConjTurmas(Set<Turma> conjTurmas)  throws ModelException {
		validarTurmas(conjTurmas);
		this.conjTurmas = conjTurmas;
	}

	public int getNumCreditos() {
		return this.numCreditos;
	}

	public void setNumCreditos(int nc) throws ModelException {
		validarNumeroDeCreditos(nc);
		this.numCreditos = nc;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int ch) throws ModelException {
		validarCargaHoraria(ch);
		this.cargaHoraria = ch;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String n) throws ModelException {
		validarNome(n);
		this.nome = n;
	}

	public static void validarNome(String n) throws ModelException {

		if (n == null || n.length() == 0)
			throw new ModelException("nome não pode ser nulo");

		int tamanho = n.length();

		if (tamanho > TAM_NOME)
			throw new ModelException("nome deve ter até 40 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char cp = n.charAt(i);
			if (!Character.isSpaceChar(cp) && !Character.isAlphabetic(cp))
				throw new ModelException("nome deve possuir apenas letras");

		}

	}

	public static void validarNumeroDeCreditos(int nc) throws ModelException {
		if (nc < 1 || nc > 100)
			throw new ModelException("O número de créditos deve ser de 1 a 100");
	}
	

	public static void validarCargaHoraria(int ch) throws ModelException {
		if (ch < 240 || ch > 580)
			throw new ModelException("a carga horaria deve estar entre 240 a 580");
	}
	
	
	public static void validarTurmas(Set<Turma> conjTurmas) throws ModelException {
		if(conjTurmas == null)
			throw new ModelException("O conjunto de turmas não pode ser nulo!");
	}
	
	

	public String toString() {
		return "Nome_Disciplina : " + " " + this.nome + " " + "Carga Horária: " + this.cargaHoraria;
	}

	

}
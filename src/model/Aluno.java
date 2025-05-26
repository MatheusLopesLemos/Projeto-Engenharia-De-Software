package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Aluno {

	final private static int TAM_CPF = 14;
	final private static int TAM_NOME = 40;
	final private static int TAM_DT = 10;
	final private static int TAM_END = 80;
	final private static int TAM_TEL = 11;

	@Id
	@GeneratedValue
	private int id_aluno;
	@Column(length = TAM_CPF, unique = true)
	private String cpf;
	@Column(length = TAM_NOME)
	private String nome;
	@Column(length = TAM_DT)
	private String dataNasc;
	@Column(length = TAM_END)
	private String endereco;
	@Column(length = TAM_TEL)
	private String telefone;
	@OneToMany(mappedBy="turma") //--> mappedBy indica qual é o nome do atributo unário presente na outra classe
	private Set<Matricula> conjMatriculas;

	public Aluno() {

	}

	public Aluno(String c, String n, String d, String e, String t) throws ModelException {
		super();
		this.setCpf(c);
		this.setNome(n);
		this.setDataNasc(d);
		this.setEndereco(e);
		this.setTelefone(t);
		this.setConjMatriculas(new HashSet<Matricula>());
	}
	
	

	public Set<Matricula> getConjMatriculas() {
		return new HashSet<Matricula>(this.conjMatriculas);
	}

	public void setConjMatriculas(Set<Matricula> conjMatriculas) throws ModelException {
		validarConjMatriculas(conjMatriculas);
		this.conjMatriculas = conjMatriculas;
	}

	public int getId_aluno() {
		return this.id_aluno;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String c) throws ModelException {
		validarCpf(c);
		this.cpf = c;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String n) throws ModelException {
		validarNome(n);
		this.nome = n;
	}

	public String getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(String d) throws ModelException {
		validarData(d);
		this.dataNasc = d;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String e) throws ModelException {
		validarEndereco(e);
		this.endereco = e;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String t) throws ModelException {
		validarTelefone(t);
		this.telefone = t;
	}

	public static void validarCpf(String c) throws ModelException {
		if (c == null)
			throw new ModelException("O cpf não pode ser nulo!");

		int tamanho = c.length();
		if (tamanho != TAM_CPF)
			throw new ModelException("O cpf deve ter 14 caracteres!");

		for (int pos = 0; pos < tamanho; pos++) {
			char cp = c.charAt(pos);

			switch (pos) {

			case 3:
			case 7:
				if (cp != '.')
					throw new ModelException("Na posição " + pos + " do cpf deve ter '.'");

				break;
			case 11:
				if (cp != '-')
					throw new ModelException("Na posição 11 do cpf deve ter '-'");

				break;
			default:
				if (!Character.isDigit(cp))
					throw new ModelException("Na posição " + pos + " do cpf deve constar um dígito: " + c);

			}

		}
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

	public static void validarData(String d) throws ModelException {

		if (d == null || d.length() == 0)
			throw new ModelException("data não pode ser nulo");

		int tamanho = d.length();

		if (tamanho != TAM_DT)
			throw new ModelException("data e hora deve ter 10 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char cp = d.charAt(i);
			switch (i) {
			case 2:
			case 5:
				if (cp != '/')
					throw new ModelException("data na posição 2 e 5 deve ser '/");
				break;
			case 10:
				if (!Character.isSpaceChar(cp))
					throw new ModelException("data na posição 10 deve ser um espaço em branco");
				break;
			default:
				if (!Character.isDigit(cp))
					throw new ModelException("data invalida");

			}

		}

		verificarData(d);

	}

	public static void verificarData(String d) throws ModelException {

		String aux = d.substring(6, 10);
		int ano = Integer.parseInt(aux);
		System.out.print(ano);
		if (ano < 2025 || ano > 2030)
			throw new ModelException("ano deve ser entre 1925 a 2025");

		String aux2 = d.substring(0, 2);
		int dia = Integer.parseInt(aux2);
		if (dia < 0 || dia > 31)
			throw new ModelException("o dia deve ser entre 0 a 31");

		String aux3 = d.substring(3, 5);
		int mes = Integer.parseInt(aux3);
		if (mes < 1 || mes > 12)
			throw new ModelException("o mes deve ser entre 1 a 12");

	}

	public static void validarEndereco(String e) throws ModelException {

		if (e == null || e.length() == 0)
			throw new ModelException("endereço não pode ser nulo");

		int tamanho = e.length();

		if (tamanho > TAM_END)
			throw new ModelException("endereço deve ter até 80 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char cp = e.charAt(i);
			if (!Character.isSpaceChar(cp) && !Character.isAlphabetic(cp))
				throw new ModelException("endereco deve possuir apenas letras");

		}

	}

	public static void validarTelefone(String t) throws ModelException {

		if (t == null || t.length() == 0)
			throw new ModelException("telefone não pode ser nulo");

		int tamanho = t.length();

		if (tamanho != TAM_TEL)
			throw new ModelException("telefone deve ter 11 numeros");

		for (int i = 0; i < tamanho; i++) {
			char cp = t.charAt(i);
			if (!Character.isDigit(cp))
				throw new ModelException("endereco deve possuir apenas letras");

		}

	}
	
	public static void validarConjMatriculas(Set<Matricula> conjMatriculas) throws ModelException {
		if(conjMatriculas == null)
			throw new ModelException("O conjunto de matriculas não pode ser nulo!");
	}

	public String toString() {
		return "CPF_Aluno : " + this.cpf + " " + "Nome_Aluno: " + this.nome;
	}

}
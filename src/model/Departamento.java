package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Departamento {

	final private static int TAM_NOME = 40;

	@Id
	@GeneratedValue
	private int id_departamento;
	@Column(length = TAM_NOME)
	private String nome;

	
	public Departamento() {
	}
	public Departamento(String n) throws ModelException {
		super();
		this.setNome(n);
	}
	
	
	public int getId_departamento() {
		return this.id_departamento;
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
	
	
	public String toString() {
		return "Id_departamento: " + this.id_departamento + " - " + "Nome_departamento: " + this.nome;
	}

}
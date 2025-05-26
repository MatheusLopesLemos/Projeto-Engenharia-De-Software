package model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



public class Realiza {
	
	@Id
	@GeneratedValue
	private int idRealiza;
	@Column
	private Double nota;
	@ManyToOne(fetch = FetchType.LAZY)
    private Matricula matricula;
    @ManyToOne(fetch = FetchType.LAZY)
    private Prova prova;
    
    
    public Realiza() {
    	
    	
    }
    
	public Realiza(Double nota, Matricula matricula, Prova prova) throws ModelException {
		super();
		this.setNota(nota);
		this.setMatricula(matricula);
		this.setProva(prova);
	}

	public Double getNota() {
		return this.nota;
	}

	public void setNota(Double nota) throws ModelException {
		validarNota(nota);
		this.nota = nota;
	}

	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) throws ModelException {
		validarMatricula(matricula);
		this.matricula = matricula;
	}

	public Prova getProva() {
		return this.prova;
	}

	public void setProva(Prova prova) throws ModelException{
		validarProva(prova);
		this.prova = prova;
	}
	
	
	public int getIdRealiza() {
		return this.idRealiza;
	}
	
	
	
	public static void validarNota(Double nota) throws ModelException {
		
		if(nota == null) {
			throw new ModelException("A nota não pode ser nula");
		}
		
		if(nota < 0 || nota > 10) {
			throw new ModelException("A nota deve ser entre 1 a 10");
		}
    
	}
	
	
	public static void validarMatricula(Matricula matricula) throws ModelException {
		
		if(matricula == null) {
			throw new ModelException("A matricula não pode ser nula");
		}
		
	}
	
	public static void validarProva(Prova prova) throws ModelException {
		
		if(prova == null) {
			throw new ModelException("A Prova não pode ser nula");
		}
		
	}
	
	
	public String toString() {
		return this.matricula + " " + this.nota;
	}
	
	
	

}

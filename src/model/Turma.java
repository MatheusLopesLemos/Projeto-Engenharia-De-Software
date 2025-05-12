package model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Turma {
	
	final private static int TAM_TURNO = 20;
	final private static int TAM_DIA_SEMANA = 20;
	
	
	@Id
	@GeneratedValue
	private int id_turma;
	@Column(length = TAM_TURNO)
	private String turno;
	@Column(length = TAM_DIA_SEMANA)
	private String diaSemana;
	@Column
	private HoraInicio horaInicio;
	@Column
	private HoraFim horaFim;
	@Column
	private int numVagas;
	@ManyToOne(fetch = FetchType.LAZY)
	private Disciplina disciplina;
	@ManyToOne(fetch = FetchType.LAZY)
	private Professor professor;
	
	

	public Turma() {

	}



	public Turma(String t, String ds, HoraInicio hi, HoraFim hf, int n, Disciplina d,
			Professor p) throws ModelException{
		super();
		this.setTurno(t);
		this.setDiaSemana(ds);
		this.setHoraInicio(hi);;
		this.setHoraFim(hf);
		this.setNumVagas(n);
		this.setDisciplina(d);
		this.setProfessor(p);
	}



	public int getId_turma() {
		return this.id_turma;
	}



	public String getTurno() {
		return this.turno;
	}



	public void setTurno(String t) throws ModelException{
		validarTurno(t);
		this.turno = t;
	}



	public String getDiaSemana() {
		return this.diaSemana;
	}



	public void setDiaSemana(String ds) throws ModelException {
		validarDiaSemana(ds);
		this.diaSemana = ds;
	}



	public HoraInicio getHoraInicio() {
		return this.horaInicio;
	}



	public void setHoraInicio(HoraInicio hi) throws ModelException{
		validarHoraInicio(hi,this.turno);
		this.horaInicio = hi;
	}



	public HoraFim getHoraFim() {
		return this.horaFim;
	}



	public void setHoraFim(HoraFim hf) throws ModelException{
		validarHoraFim(hf,this.turno);
		this.horaFim = hf;
	}



	public int getNumVagas() {
		return this.numVagas;
	}



	public void setNumVagas(int n) throws ModelException{
		validarNumeroVagas(n);
		this.numVagas = n;
	}



	public Disciplina getDisciplina() {
		return this.disciplina;
	}



	public void setDisciplina(Disciplina d) throws ModelException {
		validarDisciplina(d);
		this.disciplina = d;
	}



	public Professor getProfessor() {
		return this.professor;
	}



	public void setProfessor(Professor p) throws ModelException{
		 validarProfesssor(p);
		this.professor = p;
	}
	
	public static void validarTurno(String t) throws ModelException {

		if (t == null || t.length() == 0)
			throw new ModelException("turno não pode ser nulo");

		int tamanho = t.length();

		if (tamanho > TAM_TURNO)
			throw new ModelException("turno deve ter até 20 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char cp = t.charAt(i);
			if (!Character.isAlphabetic(cp))
				throw new ModelException("turno deve possuir apenas letras");

		}

	}
	
	public static void validarDiaSemana(String d) throws ModelException {
		if (d == null || d.length() == 0)
			throw new ModelException("dia de semana não pode ser nulo");

		int tamanho = d.length();

		if (tamanho > TAM_DIA_SEMANA)
			throw new ModelException("dia de semana deve ter até 20 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char cp = d.charAt(i);
			if (!Character.isAlphabetic(cp))
				throw new ModelException("turno deve possuir apenas letras");
		}
	}
	
	
	public static void validarHoraInicio(HoraInicio h, String t) throws ModelException {
		if(t.equals("manhã"))
			if(h.equals(HoraInicio.NOITE))
				throw new ModelException("horário inicio do turno da manhã deve iniciar a partir das 8:20");
		
		if(t.equals("noite"))
			if(h.equals(HoraInicio.MANHÃ))
				throw new ModelException("horário inicio do turno da noite deve iniciar a partir das 18:20");
		}
	
	public static void validarHoraFim(HoraFim hf, String t) throws ModelException {
		if(t.equals("manhã"))
			if(hf.equals(HoraFim.NOITE))
				throw new ModelException("horário fim do turno da manhã deve incerrar 12:00");
		
		if(t.equals("noite"))
			if(hf.equals(HoraFim.MANHÃ))
				throw new ModelException("horário fim do turno da noite deve incerrar 22:00");	
		}

	


	public static void validarNumeroVagas(int n) throws ModelException {
		if(n < 10 || n > 40)
				throw new ModelException("O número de vagas deve estar entre 10 a 40 alunos");
		}



	public static void validarDisciplina(Disciplina d) throws ModelException {
		if(d == null)
				throw new ModelException("Disciplina não pode ser nula");
		}

	public static void validarProfesssor(Professor p) throws ModelException {
		if(p == null)
				throw new ModelException("Professor não pode ser nulo");
		}



	
	public String toString() {
		return "id_turma: " + this.id_turma + " Professor: " + this.professor + " Disciplina: " + this.disciplina;
	}
	
	
	


}
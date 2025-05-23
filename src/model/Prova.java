package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;


public class Prova {
	
	final private static int TAM_DATA = 10;
	final private static int TAM_PESO = 5;
	final private static int TAM_TIPO_PROVA = 40;
	
	@Id
	@GeneratedValue
	private int id_prova;
	@Column(length = TAM_DATA)
	private String dataRealizada;
	@Column(length = TAM_PESO)
	private double peso;
	@Column(length = TAM_TIPO_PROVA)
	private String tipoProva;
	
	
	
	//@OneToMany(mappedBy="prova") //--> mappedBy indica qual é o nome do atributo unário presente na outra classe
	//private Set<Turma> conjTurmas;

	public Prova(){
		
	}
	
	public Prova(String dr, double p, String tp) throws ModelException {
		super();
		this.setDataRealizacao(dr);
		this.setPeso(p);
		this.setTipoProva(tp);
		//this.setConjTurmas(new HashSet<Turma>());
	}
	
	public int getId_prova() {
		return this.id_prova;
	}
	
	public String getDataRealizacao() {
		return this.dataRealizada;
	}

	public void setDataRealizacao(String dr) throws ModelException {
		validarDataRealizacao(dr);
		this.dataRealizada = dr;
		
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double p) throws ModelException {
		validarPeso(p);
		this.peso = p;
		
	}
	
	public String getTipoProva() {
		return this.tipoProva;
	}
	
	public void setTipoProva(String tp) throws ModelException {
		validarTipoProva(tp);
		this.tipoProva = tp;
		
	}
	

	public static void validarDataRealizacao(String dr) throws ModelException {
	    if (dr == null || dr.trim().isEmpty()) {
	        throw new ModelException("Data de realização não pode ser vazia.");
	    }
	
	    dr = dr.trim();
	
	    if (dr.length() != TAM_DATA) {
	        throw new ModelException("Data de realização deve ter exatamente " + TAM_DATA + " caracteres.");
	    }
	
	    if (dr.charAt(2) != '/' || dr.charAt(5) != '/') {
	        throw new ModelException("Formato de data inválido. Use dd/MM/yyyy.");
	    }
	
	    try {
	        int dia = Integer.parseInt(dr.substring(0, 2));
	        int mes = Integer.parseInt(dr.substring(3, 5));
	        int ano = Integer.parseInt(dr.substring(6, 10));
	
	        // Data atual
	        Calendar hoje = Calendar.getInstance();
	        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
	        int mesAtual = hoje.get(Calendar.MONTH) + 1; // Janeiro = 0, por isso soma 1
	        int anoAtual = hoje.get(Calendar.YEAR);
	
	        // Verifica se a data é válida no calendário
	        if (mes < 1 || mes > 12) {
	            throw new ModelException("Mês inválido.");
	        }
	
	        if (dia < 1) {
	            throw new ModelException("Dia inválido.");
	        }
	
	        int maxDias;
	        switch (mes) {
	            case 4: case 6: case 9: case 11:
	                maxDias = 30;
	                break;
	            case 2:
	                boolean bissexto = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
	                maxDias = bissexto ? 29 : 28;
	                break;
	            default:
	                maxDias = 31;
	        }
	
	        if (dia > maxDias) {
	            throw new ModelException("Dia inválido para o mês informado.");
	        }
	
	        // Verifica se a data é posterior à data atual
	        if (ano < anoAtual
	            || (ano == anoAtual && mes < mesAtual)
	            || (ano == anoAtual && mes == mesAtual && dia <= diaAtual)) {
	            throw new ModelException("A data deve ser posterior à data atual.");
	        }
	
	    } catch (NumberFormatException e) {
	        throw new ModelException("A data contém números inválidos.");
	    }
	}
		
	public static void validarPeso(double p) throws ModelException {
		if (p <= 0 || p > TAM_PESO) {
		    throw new ModelException("Peso da prova deve estar entre 0 e " + TAM_PESO + ".");
		 }
	}
		
	public static void validarTipoProva(String tp) throws ModelException {
		if (tp == null || tp.trim().isEmpty()) {
		    throw new ModelException("Tipo de prova não pode ser vazio.");
		}
		if (tp.length() > TAM_TIPO_PROVA) {
		    throw new ModelException("Tipo de prova excede o tamanho máximo permitido.");
		}
	}
	
	


}

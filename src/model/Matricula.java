package model;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Matricula {
	
	final private static int TAM_DATA = 10;
	
	@Id
	@GeneratedValue
	private int id_matricula;
	@Column(length = TAM_DATA)
	private String data;

	public Matricula(String d) throws ModelException {
		super();
		this.setData(d);
	}
	
	public int getId_matricula() {
		return this.id_matricula;
	}
	
	public String getData() {
		return this.data;
	}

	public void setData(String d) throws ModelException {
		validarData(d);
		this.data = d;
		
	}
	
	
	public static void validarData(String d) throws ModelException {
	    if (d == null || d.trim().isEmpty()) {
	        throw new ModelException("Data de realização não pode ser vazia.");
	    }
	
	    d = d.trim();
	
	    if (d.length() != TAM_DATA) {
	        throw new ModelException("Data de realização deve ter exatamente " + TAM_DATA + " caracteres.");
	    }
	
	    if (d.charAt(2) != '/' || d.charAt(5) != '/') {
	        throw new ModelException("Formato de data inválido. Use dd/MM/yyyy.");
	    }
	
	    try {
	        int dia = Integer.parseInt(d.substring(0, 2));
	        int mes = Integer.parseInt(d.substring(3, 5));
	        int ano = Integer.parseInt(d.substring(6, 10));
	
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

}

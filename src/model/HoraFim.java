package model;

public enum HoraFim {
	
	MANHÃ("12:00"),
	NOITE("22:00");
	
	final private String txt;
	
	private HoraFim(String t) {
		this.txt = t;
		
	}
	
	public String getEstilo() {
		return this.txt;
	}
	
	
	public String toString() {
		return this.txt;
	}

}
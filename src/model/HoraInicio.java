package model;

public enum HoraInicio {
	
	MANHÃ("8:20"),
	NOITE("18:20");
	
	final private String txt;
	
	private HoraInicio(String t) {
		this.txt = t;
		
	}
	
	public String getEstilo() {
		return this.txt;
	}
	
	
	public String toString() {
		return this.txt;
	}

}
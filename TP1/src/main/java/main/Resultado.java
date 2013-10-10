package main;

public class Resultado {

	
	protected Integer id;
	protected Team team;
	protected String resultado;
	
	public Resultado(Team t, String result){
		this.team = t;
		this.resultado = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}

package main;

public class Resultado {

	
	protected Integer id;
	protected Team teamGanador;
	protected Team teamPerdedor;
	protected String resultado;
	
	public Resultado(Team tg,Team tp, String result){
		this.teamGanador = tg;
		this.teamPerdedor = tp;
		this.resultado = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeamGanador() {
		return teamGanador;
	}

	public void setTeamGanador(Team teamGanador) {
		this.teamGanador = teamGanador;
	}

	public Team getTeamPerdedor() {
		return teamPerdedor;
	}

	public void setTeamPerdedor(Team teamPerdedor) {
		this.teamPerdedor = teamPerdedor;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}

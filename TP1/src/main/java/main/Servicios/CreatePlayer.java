package main.Servicios;

import main.Player;
import main.DAOS.PlayerDAO;

public class CreatePlayer implements Operation<Player> {

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getNro() {
		return score;
	}

	public void setNro(Integer nro) {
		this.score = nro;
	}

	private String nombre;
	private String position;
	private Integer score;

	public CreatePlayer(String nombre, String position, int score) {
		super();
		this.nombre = nombre;
		this.position = position;
		this.score = score;
		
	}

	public Player execute() {
		Player j = new Player(nombre, position, score);
		new PlayerDAO().save(j);
		return j;
	}
}
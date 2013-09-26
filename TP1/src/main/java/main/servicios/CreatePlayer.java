package main.servicios;

import main.Player;
import main.daos.PlayerDao;

public class CreatePlayer implements Operation<Player>{

	protected String name;
	protected String position;
	protected int number;
	protected int puntaje;

	public CreatePlayer(String name,String pos, int puntaje, int number){
		super();
		this.name = name;
		this.position = pos;
		this.number = number;
		this.puntaje = puntaje;
	}

	public Player execute() {
		Player j = new Player(name, position, puntaje,number);
		new PlayerDao().save(j);
		return j;
	}
}

package main.servicios;

import main.Player;
import main.daos.PlayerDao;



public class ConsultPlayer implements Operation<Player>{

	private int id;
	private String name;
	private int number;
	
	public ConsultPlayer(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public Player execute() {
		Player j;
		j = new PlayerDao().getPlayer(name,number);
		return j;
	}
}

package main.servicios;

import java.util.List;
import main.Player;
import main.DAOS.PlayerDAO;

public class ConsultPlayers implements Operation<List<Player>>{

	private String name;
	private String position;
	
	public ConsultPlayers(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}
	
	public List<Player> execute() {
		return (new PlayerDAO().getPlayers(name, position));
	}
	
}

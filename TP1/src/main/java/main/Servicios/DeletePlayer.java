package main.Servicios;

import java.util.List;

import main.Player;
import main.DAOS.PlayerDAO;
import main.DAOS.SessionManager;

public class DeletePlayer implements Operation<Player> {

	private String name;
	private String position;
	
	public DeletePlayer(String name) {
		super();
		this.name = name;
		// FALTA AGREGAR POSICION AL CRITERIO
		this.position = position;
	}
	
	public Player execute() {
		Player p = (Player)new PlayerDAO().deletePlayers(name);
		SessionManager.getSession().delete(p);
		return null;
	}
}

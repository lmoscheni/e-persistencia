package main.servicios;

import main.Player;
import main.Tournament;
import main.DAOS.PlayerDAO;
import main.DAOS.SessionManager;
import main.DAOS.TournamentDAO;

public class DeleteTournament implements Operation<Tournament>{

	protected String name;
	
	public DeleteTournament(String name){
		super ();
		this.name = name;
	}
	
	public Tournament execute(){
		Tournament t = (Tournament) new TournamentDAO().deleteTournament(this.name);
		SessionManager.getSession().delete(t);
		return null;
	}
}


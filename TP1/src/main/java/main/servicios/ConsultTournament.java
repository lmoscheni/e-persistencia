package main.servicios;

import java.util.List;

import main.Player;
import main.Tournament;
import main.DAOS.PlayerDAO;
import main.DAOS.TournamentDAO;

public class ConsultTournament implements Operation<Tournament>{

	private String name;
	
	public ConsultTournament(String name){
		this.name = name;
	}
	
	public Tournament execute(){
		return (new TournamentDAO().getTournament(this.name));
	}
}



package main.Servicios;

import java.util.ArrayList;

import main.Formation;
import main.Player;
import main.Tournament;
import main.DAOS.FormationDAOS;
import main.DAOS.TournamentDAO;

public class CreateTournament implements Operation<Tournament>{

	protected Tournament tournament;
	
	public CreateTournament(Tournament t){
		this.tournament =t;
	}

	public Tournament execute() {
		new TournamentDAO().save(this.tournament);
		return this.tournament;
	}
}

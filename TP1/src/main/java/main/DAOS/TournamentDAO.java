package main.DAOS;

import main.Formation;
import main.Tournament;

public class TournamentDAO {

	public Tournament get(int id){
		return (Tournament)SessionManager.getSession().get(Formation.class,id);
	}
	
	public void save(Tournament j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
}

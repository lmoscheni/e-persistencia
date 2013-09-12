package main;

import java.util.List;

public class Tournament {
	
	protected List<Team> teams;
	
	public Tournament() {
	} 
	
	public void addTeam(Team t){
		this.teams.add(t);
	}
}

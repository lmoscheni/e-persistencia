package main;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	
	protected List<Team> teams;
	protected List<Match> matches;
	protected Integer id;
	
	public Tournament() {
		this.teams = new ArrayList<Team>();
		this.matches = new ArrayList<Match>();
	} 
	
	public void addTeam(Team t){
		this.teams.add(t);
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

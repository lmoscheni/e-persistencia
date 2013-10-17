package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class PlayOff {

	protected List<Team> group1 = new ArrayList<Team>();
	protected List<Team> group2 = new ArrayList<Team>();
	protected List<Team> group3 = new ArrayList<Team>();
	protected List<Team> group4 = new ArrayList<Team>();
	protected List<Team> group5 = new ArrayList<Team>();
	protected List<Team> group6 = new ArrayList<Team>();
	protected List<Team> group7 = new ArrayList<Team>();
	protected List<Team> group8 = new ArrayList<Team>();
	protected List<Team> allTeams;
	
	public PlayOff(List<Team> teams){
		this.group1 = this.generateGroup();
		this.group2 = this.generateGroup();
		this.group3 = this.generateGroup();
		this.group4 = this.generateGroup();
		this.group5 = this.generateGroup();
		this.group6 = this.generateGroup();
		this.group7 = this.generateGroup();
		this.group8 = this.generateGroup();
		this.allTeams = teams;
	}
	
	public List<Team> generateGroup(){
		List<Team> teamsReturn = new ArrayList<Team>();
		Random r = new Random();
		for(int i=0; i<3; i++){
			int random = r.nextInt(this.allTeams.size());
			teamsReturn.add(this.allTeams.get(random));
			this.allTeams.remove(random);
		}
		return teamsReturn;
	}
	
	public List<Team> getWinners(){
		
	}
	
	public void generateMatches(){
		int size = this.teams.size() - 1;
		Calendar dateOfMatch = Calendar.getInstance();
		int day = 1;
		for(int i=0; i < size;i++){
			for(int j=i; j<size; j++){
				this.matches.add(new Match(this.teams.get(i),this.teams.get(j + 1),dateOfMatch.getTime()));
			}
			day++;
		}
	}
	
	public void startTournament(){
		for(Match m: this.matches){
			m.matchResult();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

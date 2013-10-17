package main;

import java.util.ArrayList;
import java.util.Calendar;

public class AllAgainstAll extends Tournament {

	
	public AllAgainstAll(){}
	
	public AllAgainstAll(String name){
		super(name);
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

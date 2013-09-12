package main;

import java.util.ArrayList;
import java.util.Calendar;

public class AllAgainstAll extends Tournament {

	protected ArrayList<Match> matches;
	
	public AllAgainstAll(){}
	
	public void generateMatches(){
		int size = this.teams.size() - 1;
		Calendar dateOfMatch = null;
		int day = 1;
		for(int i=0; i < size;i++){
			for(int j=i; j<size; j++){
				this.matches.add(new Match(this.teams.get(i),this.teams.get(j + 1), dateOfMatch.DAY_OF_YEAR,dateOfMatch.DAY_OF_MONTH,day));
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

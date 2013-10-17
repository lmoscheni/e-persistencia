package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Cup extends Tournament {

	protected List<Match> matches;
	protected PlayOff playersOff;
	protected List<Team> groupWinners;
	
	public Cup(){}
	
	public Cup(List<Team> teams){
		this.teams = teams;
	}
	
	public void playOffResults(){
		this.playersOff = new PlayOff(this.teams);
		this.groupWinners = this.playersOff.getWinners();
	}
	
}

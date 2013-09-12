package main;

import java.util.List;

public class Team {

	protected List<Formation> formation;
	protected Formation currentFormation;
	
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public Formation getCurrentFormation(){
		return this.currentFormation;
	}

}

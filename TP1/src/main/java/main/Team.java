package main;

import java.util.List;

public class Team {

	protected List<Formation> formation;
	protected Formation currentFormation;
	protected Integer id;
	
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public Formation getCurrentFormation(){
		return this.currentFormation;
	}

	public List<Formation> getFormation() {
		return formation;
	}

	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCurrentFormation(Formation currentFormation) {
		this.currentFormation = currentFormation;
	}
	
	

}

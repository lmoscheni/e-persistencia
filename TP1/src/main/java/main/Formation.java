package main;

import java.util.ArrayList;
import java.util.List;

public class Formation {
	Player goalkeeper;
	List<Player> defenders = new ArrayList<Player>();
	List<Player> midfields = new ArrayList<Player>();
	List<Player> fowards = new ArrayList<Player>();
	List<Player> suplents = new ArrayList<Player>();
	protected Integer id;
	
	// Constructor para Hibernate
	protected Formation(){
		this.goalkeeper = null;
		this.defenders = null;
		this.midfields = null;
		this.fowards = null;
		this.suplents = null;
	}
	
	public Formation(List<Player> def, List<Player> mid, List<Player> fow, Player goal){
		this.defenders = def;
		this.midfields = mid;
		this.fowards = fow;
		this.goalkeeper = goal;
	}
	
	
	
	
	public Player getGoalkeeper() {
		return goalkeeper;
	}

	public void setGoalkeeper(Player goalkeeper) {
		this.goalkeeper = goalkeeper;
	}

	public List<Player> getDefenders() {
		return defenders;
	}

	public void setDefenders(List<Player> defenders) {
		this.defenders = defenders;
	}

	public List<Player> getMidfields() {
		return midfields;
	}

	public void setMidfields(List<Player> midfields) {
		this.midfields = midfields;
	}

	public List<Player> getFowards() {
		return fowards;
	}

	public void setFowards(List<Player> fowards) {
		this.fowards = fowards;
	}

	public List<Player> getSuplents() {
		return suplents;
	}

	public void setSuplents(List<Player> suplents) {
		this.suplents = suplents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int calculateTotalScore(){
		int puntaje = 0;
		// Calculando el puntaje de la Formation
		for(Player j : this.generateHeadLinesList()){
			puntaje = puntaje + j.getPuntaje();
		}
		
		return puntaje;
	}
	
	protected List<Player> generateHeadLinesList(){
		
		// Creando una lista donde alojamos a todos los Playeres titulares
		List<Player> result = new ArrayList<Player>();
		// Agregando a todos los Playeres titulares a la lista
		result.addAll(this.defenders);
		result.addAll(this.midfields);
		result.addAll(this.fowards);
		result.add(this.goalkeeper);
		
		return result;
	}
	
	
}

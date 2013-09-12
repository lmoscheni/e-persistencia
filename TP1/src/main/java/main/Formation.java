package main;

import java.util.ArrayList;
import java.util.List;

public class Formation {
	Player goalkeeper;
	List<Player> defenders;
	List<Player> midfields;
	List<Player> fowards;
	List<Player> suplents;
	
	// Constructor para Hibernate
	protected Formation(){
		this.goalkeeper = null;
		this.defenders = null;
		this.midfields = null;
		this.fowards = null;
		this.suplents = null;
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

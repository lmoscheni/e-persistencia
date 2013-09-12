package main;

public class Player {

	protected String posicion;
	protected int puntaje;
	
	//Constructor para hibernate. NO USAR!!
	protected Player(){}
	
	public Player(String pos, int puntaje) {
		this.posicion = pos;
		this.puntaje = puntaje;
	}

	public int getPuntaje() {
		return this.puntaje;
	}

}

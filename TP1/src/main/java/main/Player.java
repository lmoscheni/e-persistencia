package main;

public class Player {

	private Integer id;
	protected String name;
	protected String position;
	protected int score;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	//Constructor para hibernate. NO USAR!!
	protected Player(){}
	
	public Player(String name, String pos, int puntaje) {
		this.name = name;
		this.position = pos;
		this.score = puntaje;
	}

	public int getPuntaje() {
		return this.score;
	}

}

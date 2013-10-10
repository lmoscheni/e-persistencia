package main;

import java.util.Calendar;
import java.util.Date;

public class Match {

	protected Team teamLocal;
	protected Team teamVisitor;
	protected Date matchDate = new Date();
	protected Integer id;
	protected Resultado matchResult; 
	
	public Match(Team t1,Team t2,Date date) {
		this.teamLocal = t1;
		this.teamVisitor = t2;
		this.matchDate = date;
	}
	
	
	public Team getTeamLocal(){
		return this.teamLocal;
	}
	
	public Team getTeamVisitor(){
		return this.teamVisitor;
	}
	
	
	public Date getMatchDate() {
		return matchDate;
	}


	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Resultado getMatchResult() {
		return matchResult;
	}


	public void setMatchResult(Resultado matchResult) {
		this.matchResult = matchResult;
	}


	public void setTeamLocal(Team teamLocal) {
		this.teamLocal = teamLocal;
	}


	public void setTeamVisitor(Team teamVisitor) {
		this.teamVisitor = teamVisitor;
	}


	public void setDate(int year,int month,int date){
		this.matchDate.setDate(date);
		this.matchDate.setMonth(month);
		this.matchDate.setYear(year);
	}
	
	public double calcularPorcentaje(double x, int porcentaje){
		return (15 * x) /100;
	}
	
	public void matchResult(){
		double scoreTeamLocal = (this.teamLocal.getCurrentFormation().calculateTotalScore()) * ((Math.random() * 0.2) + 0.9);
		double scoreTeamVisitor = (this.teamVisitor.getCurrentFormation().calculateTotalScore() * ((Math.random() * 0.2) + 0.9));
		if((this.calcularPorcentaje(scoreTeamLocal, 15)+ scoreTeamLocal) >= scoreTeamVisitor) 
			this.matchResult = new Resultado(this.teamLocal, "Ganador");
		if((this.calcularPorcentaje(scoreTeamVisitor, 20)+ scoreTeamVisitor) >= scoreTeamLocal)
			this.matchResult = new Resultado(this.teamVisitor, "Ganador");
		this.matchResult = new Resultado(null, "Empate");
	}

}

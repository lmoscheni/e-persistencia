package main;

import java.util.Calendar;

public class Match {

	protected Team teamLocal;
	protected Team teamVisitor;
	protected Calendar matchDate;
	
	public Match(Team t1,Team t2,int year,int month,int date) {
		this.teamLocal = t1;
		this.teamVisitor = t2;
		this.matchDate.set(year, month, date);
	}
	
	
	public Team getTeamLocal(){
		return this.teamLocal;
	}
	
	public Team getTeamVisitor(){
		return this.teamVisitor;
	}
	
	public void setDate(int year,int month,int date){
		this.matchDate.set(year, month, date);
	}
	
	public double calcularPorcentaje(double x, int porcentaje){
		return (15 * x) /100;
	}
	
	public Resultado matchResult(){
		double scoreTeamLocal = (this.teamLocal.getCurrentFormation().calculateTotalScore()) * ((Math.random() * 0.2) + 0.9);
		double scoreTeamVisitor = (this.teamVisitor.getCurrentFormation().calculateTotalScore() * ((Math.random() * 0.2) + 0.9));
		if((this.calcularPorcentaje(scoreTeamLocal, 15)+ scoreTeamLocal) >= scoreTeamVisitor) 
			return Resultado.LOCAL;
		if((this.calcularPorcentaje(scoreTeamVisitor, 20)+ scoreTeamVisitor) >= scoreTeamLocal)
			return Resultado.VISITANTE;
		return Resultado.EMPATE;
	}

}

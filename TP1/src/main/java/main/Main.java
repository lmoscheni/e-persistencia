package main;

import java.util.ArrayList;
import java.util.List;

import main.servicios.ConsultPlayers;
import main.servicios.ConsultTournament;
import main.servicios.CreateFormation;
import main.servicios.CreatePlayer;
import main.servicios.CreateTournament;
import main.servicios.DeletePlayer;

public class Main {

	public static void main(String[] args) throws Exception{
		//VirtualDT v = new VirtualDT();
		//v.registrateUser("matiCapo", "mati", "beka", "beca@hot.com", "30/13/2200", "5656");
		//v.changePassword("matiCapo", "123545");
		//v.registrateUser("juliCapo", "Julian", "Skalic", "skalic.julian@gmail.com", "17/02/1992", "julianskalic");
		//v.login("juliCapo", "565");
		//v.validationUser("juliCapo", "XW6EW6P");
		/*
		Player p1 = new Player("juli", "delantero", 10);
		Player p2 = new Player("lea", "delantero", 10);
		Player p3 = new Player("mati", "delantero", 10);
		Player p4 = new Player("mati", "delantero", 10);
		Player p5 = new Player("juan", "delantero", 10);
		Player p6 = new Player("pepe", "delantero", 10);
		Player p7 = new Player("fer", "delantero", 10);
		
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> fow = new ArrayList<Player>();
		
		mid.add(p1);
		mid.add(p2);
		mid.add(p3);
		
		def.add(p4);
		def.add(p5);
		
		fow.add(p6);
		fow.add(p7);
		
		Team t1 = new Team("Equipo rojo");
		Team t2 = new Team("Equipo amarillo");
		t1.setCurrentFormation(new Formation(def,mid,fow,p1));
		t2.setCurrentFormation(new Formation(def,mid,fow,p1));
		
		AllAgainstAll tournament = new AllAgainstAll("Torneo de verano");
		tournament.addTeam(t1);
		tournament.addTeam(t2);
		tournament.generateMatches();
		tournament.startTournament();
		*/
		AllAgainstAll tournament = new AllAgainstAll("Torneo de verano");
		main.DAOS.SessionManager.runInSession(new CreateTournament(tournament));
		Tournament t = main.DAOS.SessionManager.runInSession(new ConsultTournament("Torneo de verano"));
		System.out.print(t.getNameTournament());
		//Runtime.getRuntime().exec("mysql new_schema -u root --password=root < matigenio.sql").waitFor();
		//System.out.println(a.get(0).name);
	}

}

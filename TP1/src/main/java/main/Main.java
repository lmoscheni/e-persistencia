package main;

import java.util.ArrayList;
import java.util.List;

import main.Servicios.ConsultPlayers;
import main.Servicios.CreatePlayer;
import main.Servicios.DeletePlayer;

public class Main {

	public static void main(String[] args) throws Exception{
		//VirtualDT v = new VirtualDT();
		//v.registrateUser("matiCapo", "mati", "beka", "beca@hot.com", "30/13/2200", "5656");
		//v.changePassword("matiCapo", "123545");
		//v.registrateUser("juliCapo", "Julian", "Skalic", "skalic.julian@gmail.com", "17/02/1992", "julianskalic");
		//v.login("juliCapo", "565");
		//v.validationUser("juliCapo", "XW6EW6P");
		
		main.DAOS.SessionManager.runInSession(new DeletePlayer("Matuteee"));
		//System.out.println(a.get(0).name);
	}

}

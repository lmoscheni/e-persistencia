package main.servicios;

import java.util.ArrayList;

import main.Formation;
import main.Player;
import main.DAOS.FormationDAOS;
import main.DAOS.PlayerDAO;

public class CreateFormation implements Operation<Formation>{

	protected ArrayList<Player> defenders;
	protected ArrayList<Player> midfields;
	protected ArrayList<Player> fowards;
	protected Player goalkeper;
	
	public CreateFormation(ArrayList<Player> defenders,ArrayList<Player> midfields,ArrayList<Player> fowards, Player goal){
		this.defenders = defenders;
		this.midfields = midfields;
		this.fowards = fowards;
		this.goalkeper = goal;
	}

	public Formation execute() {
		Formation j = new Formation(defenders, midfields, fowards, goalkeper);
		new FormationDAOS().save(j);
		return j;
	}
}

package main.DAOS;

import java.util.List;

import main.Formation;
import main.Player;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class FormationDAOS {

	public Formation get(int id){
		return (Formation)SessionManager.getSession().get(Formation.class,id);
	}
	
	public void save(Formation j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
}

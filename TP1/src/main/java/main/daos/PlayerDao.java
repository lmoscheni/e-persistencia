package main.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.Player;

public class PlayerDao {

	public Player get(String name,int id){
		return (Player)SessionManager.getSession().get(Player.class,id);
	}
	
	public Player getPlayer(String name, int number){
		Criteria var = SessionManager.getSession().createCriteria(Player.class);
		var.add(Restrictions.eq("name",name));
		var.add(Restrictions.eq("number",number));
		return (Player)var.uniqueResult();
	}
	
	public void save(Player j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
}

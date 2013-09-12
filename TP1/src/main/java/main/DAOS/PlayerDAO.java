package main.DAOS;

import main.Player;
import java.util.List;

import javax.mail.Session;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PlayerDAO {

	public Player get(int id){
		return (Player)SessionManager.getSession().get(Player.class,id);
	}
	
	public List<Player> getPlayers(String name, String position) {
		Criteria cri = SessionManager.getSession().createCriteria(Player.class);
		cri.add(Restrictions.eq("name", name));
		cri.add(Restrictions.eq("position", position));
		return cri.list();
	}
	
	public Player deletePlayers(String name) {
		Criteria cri = SessionManager.getSession().createCriteria(Player.class);
		cri.add(Restrictions.eq("name", name));
		return (Player)cri.uniqueResult();
	}

	public void save(Player j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
	
}

package main.DAOS;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.Formation;
import main.Player;
import main.Tournament;

public class TournamentDAO {

	
	public Tournament getTournament(String name) {
		Criteria cri = SessionManager.getSession().createCriteria(Tournament.class);
		cri.add(Restrictions.eq("nameTournament", name));
		return (Tournament) cri.uniqueResult();
	}
	
	public Tournament deleteTournament(String name){
		Criteria cri = SessionManager.getSession().createCriteria(Tournament.class);
		cri.add(Restrictions.eq("nameTournament", name));
		return (Tournament)cri.uniqueResult();
	}
	
	public void save(Tournament j) {
		SessionManager.getSession().saveOrUpdate(j);
	}
}

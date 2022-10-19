package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Player;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 11, 2022
 */
public class PlayerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupProjectWeek7");
	/**
	 * 
	 */
	public PlayerHelper() {
		super();
	}

	//insert a Player
	public void insertPlayer(Player p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	//show all players
	public List<Player> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT s FROM Player s").getResultList();
		return allPlayers;
	}
	
	//search Methods
	public Player findPlayer(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select p from Player p where p.playerName = :selectedName", Player.class);
		typedQuery.setParameter("selectedName", name);
		typedQuery.setMaxResults(1);
		
		Player foundPlayer;
		try {
			foundPlayer = typedQuery.getSingleResult();
		}
		catch(NoResultException ex) {
			foundPlayer = new Player(name);
		}
		em.close();
		
		return foundPlayer;
	}
}

package com.awudima.mytaxi.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.model.Taxi;
/**
 * 
 * @author kemele
 *
 */
public class TaxiDAO {

	private EntityManager em;
	private static TaxiDAO taxiDAO = new TaxiDAO();
	
	public TaxiDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public EntityManager getEntityManger(){
		return em;
	}
	public static TaxiDAO getInstance(){
		return taxiDAO;
	}
	public Taxi addTaxi(Taxi taxi) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(taxi);
		tx.commit();
		
		return taxi;
	}
	
	public Taxi getTaxi(int id) throws Exception{
		Taxi taxi = em.find(Taxi.class, id);
		return taxi;
	}
	
	public Taxi update(Taxi taxi )throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(taxi);
		tx.commit();
		return taxi;
	}
	
	
	public boolean delete(int id)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Taxi taxi = this.getTaxi(id);
		if(taxi == null)
			return false;
		em.remove(taxi);
		tx.commit();
		return true;
	}
	
	public List<Taxi> getAll() throws Exception{
		List<Taxi> taxis = em.createQuery("SELECT t FROM Taxi t", Taxi.class).getResultList();
		return taxis;
	}
	
	public List<Taxi> getAll(String var, String value) throws Exception{
		List<Taxi> taxis = em.createQuery("SELECT t FROM Taxi t WHERE t."+var +" = "+value, Taxi.class).getResultList();
		return taxis;
	}
	
	
	/**
	 * closes a connection to database set to entity manager {@link em}
	 */
	public void closeConnection(){
		  em.close();
	}
	
	public static void main(String[] args) throws Exception{		
		Taxi taxi = TaxiDAO.getInstance().getTaxi(1);
		System.out.println(taxi.getPlateNum() + " " + taxi.getTaxiType());
		
		List<Taxi> ts = TaxiDAO.getInstance().getAll();
		for(Taxi t: ts){
			System.out.println(t.getId() + " " + t.getPlateNum());
		}
	}

}

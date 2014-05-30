package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.model.Passenger;
/**
 * 
 * @author kemele
 *
 */
public class PassengerDAO {

	private EntityManager em;
	private static PassengerDAO passengerDAO = new PassengerDAO();
	
	
	public PassengerDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static PassengerDAO getInstance(){
		return passengerDAO;
	}
	
	public Passenger addPassenger(Passenger passenger) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(passenger);
		tx.commit();
		return passenger;
		
	}
	
	public Passenger update(Passenger passenger)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(passenger);
		tx.commit();
		return passenger;
	}
	
	public Passenger getPassenger(String phoneNumber)throws Exception{
		Passenger passenger = em.find(Passenger.class, phoneNumber);
		return passenger;
	}
	
	public boolean delete(String phoneNumber) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Passenger passenger = this.getPassenger(phoneNumber);
		if(passenger == null)
			return false;
		em.remove(passenger);
		return true;
	}
	
	public List<Passenger> getAll()throws Exception{
		List<Passenger> passengers = em.createQuery("SELECT p FROM Passenger p", Passenger.class).getResultList();
		return passengers;
	}
	
	public static void main(String[] args) throws Exception{
		Passenger p = PassengerDAO.getInstance().getPassenger("+33626076455");
		System.out.println(p.getName());
	}

}

package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.model.Driver;
/**
 * 
 * @author kemele
 *
 */
public class DriverDAO {

	private EntityManager em;
	private static DriverDAO driverDAO = new  DriverDAO();
	public DriverDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static DriverDAO getInstance(){
		return driverDAO;
	}
	
	public Driver addDriver(Driver driver) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(driver);
		tx.commit();
		return driver;
	}
	
	public Driver update(Driver driver) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(driver);
		tx.commit();
		return driver;
	}
	
	public Driver getDriver(String phoneNumber) throws Exception{
		Driver driver = em.find(Driver.class, phoneNumber);
		return driver;
	}
	
	public boolean delete(String phoneNumber)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Driver driver = this.getDriver(phoneNumber);
		if(driver == null)
			return false;
		em.remove(driver);
		return true;
	}
	
	public List<Driver> getAll()throws Exception{
		List<Driver> drivers = em.createQuery("SELECT d FROM Driver d", Driver.class).getResultList();
		return drivers;
	}
	
	public static void main(String a[])throws Exception{
		Driver d =DriverDAO.getInstance().getDriver("+251918791209");
		
		System.out.println(d.getName());
	}
}

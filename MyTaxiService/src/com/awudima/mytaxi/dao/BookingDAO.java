package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.constants.UserType;
import com.awudima.mytaxi.model.Booking;
/**
 * 
 * @author kemele
 *
 */
public class BookingDAO {

	
	private EntityManager em;
	private static BookingDAO bookingDAO = new BookingDAO();
	
	public BookingDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static BookingDAO getInstance(){
		return bookingDAO;
	}
	
	public Booking addBooking(Booking book) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book);
		tx.commit();
		return book;
	}
	
	public Booking update(Booking book)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(book);
		tx.commit();
		return book;
	}
	
	public Booking getBooking(int id)throws Exception{
		Booking book = em.find(Booking.class, id);
		return book;
	}
	
	public boolean delete(int id)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Booking book = this.getBooking(id);
		if(book == null)
			return false;
		em.remove(book);
		return true;
	}
	
	public List<Booking> getAll(String phone, int userType){
	
		List<Booking> books;
		String cond = "";
		if(userType == UserType.PASSENGER)
			cond = " b.passengerPhone = " + phone;
		else
			cond =" b.driverPhone = " + phone;
			books = em.createQuery("SELECT b FROM booking b WHERE "+cond, Booking.class).getResultList();
		
		return books;
	}
	
	public List<Booking> getAll() throws Exception{
		List<Booking> books = em.createQuery("SELECT b FROM booking b", Booking.class).getResultList();
		return books;
	}
	public static void main(String[] args) {
		
	}

}

package com.awudima.mytaxi.dao;

import java.sql.Timestamp;
import java.util.Date;
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
			books = em.createQuery("SELECT b FROM Booking b WHERE "+cond, Booking.class).getResultList();
		
		return books;
	}
	
	public List<Booking> getAll(int status, String phone, int userType){
		
		List<Booking> books;
		String cond = "";
		if(userType == UserType.PASSENGER)
			cond = " b.passengerPhone = " + phone;
		else
			cond =" b.driverPhone = " + phone;
			books = em.createQuery("SELECT b FROM Booking b WHERE b.status =  " + status + " AND " +cond, Booking.class).getResultList();
		
		return books;
	}
	
	public List<Booking> getAll() throws Exception{
		List<Booking> books = em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
		return books;
	}
	public static void main(String[] args) throws Exception {
		Booking b = new Booking();
		b.setDriver(DriverDAO.getInstance().getDriver("+251918791209"));
		b.setPassenger(PassengerDAO.getInstance().getPassenger("+33626076455"));
		b.setBfrom("kebele 4");
		b.setBto("BDR University");
		b.setPickuptime(new Timestamp(new Date().getTime()));
		b.setPickupLocation("Mosque 04");
		b.setStatus(0+"");
		b.setNoteToDriver("Please dont pick another passenger, we are 3");
		b.setStatusUpdateTime(new Timestamp(new Date().getTime()));
		b.setPricing("Contract");
		
		//Booking bs = BookingDAO.getInstance().addBooking(b);
		List<Booking> bss = BookingDAO.getInstance().getAll();
		for(Booking bs: bss)
		System.out.println(bs.getId());
	}

}

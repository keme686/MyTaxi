package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.constants.UserType;
import com.awudima.mytaxi.model.Rating;
/**
 * 
 * @author kemele
 *
 */
public class RatingDAO {

	private EntityManager em;
	private static RatingDAO ratingDAO = new RatingDAO();
	
	public RatingDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static RatingDAO getInstance(){
		return ratingDAO;
	}
	
	public Rating addRating(Rating rating) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(rating);
		tx.commit();
		return rating;		
	}
	
	public Rating update(Rating rating) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(rating);
		tx.commit();
		return rating;
		
	}
	
	public boolean delete(int id)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Rating r = em.find(Rating.class, id);
		if(r == null)
			tx.rollback();
		else{
			em.remove(r);
			tx.commit();
			return true;
		}
		return false;
	}
	public Rating getRating(int id)throws Exception {
		Rating rating = em.find(Rating.class, id);
		return rating;
	}
	public List<Rating> getRating(String phone, int userType)throws Exception{
		List<Rating> ratings;
		String cond="";
		if(userType == UserType.DRIVER){
			cond =" r.driverPhone = " + phone;
		}else{
			cond = " r.passengerPhone = " + phone;
		}
		ratings = em.createQuery("SELECT r FROM Rating r WHERE " + cond, Rating.class).getResultList();
		return ratings;
	}
	
	public List<Rating> getAll()throws Exception{
		List<Rating> ratings = em.createQuery("SELECT r FROM Rating r", Rating.class).getResultList();
		return ratings;
	}
	
	public static void main(String[] args) {

	}

}

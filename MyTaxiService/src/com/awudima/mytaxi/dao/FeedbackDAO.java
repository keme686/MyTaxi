package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.constants.UserType;
import com.awudima.mytaxi.model.Feedback;
/**
 * 
 * @author kemele
 *
 */
public class FeedbackDAO {

	private EntityManager em;
	private static FeedbackDAO feedbackDAO = new FeedbackDAO();
	
	public FeedbackDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static FeedbackDAO getInstance(){
		return feedbackDAO;
	}
	
	public Feedback addFeedback(Feedback feedback)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(feedback);
		tx.commit();
		return feedback;
	}
	
	public Feedback update(Feedback feedback)throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(feedback);
		tx.commit();
		return feedback;
	}
	
	public Feedback getFeedback(int id)throws Exception {
		Feedback feedback = em.find(Feedback.class, id);
		return feedback;
	}
	
	public boolean delete(int id)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Feedback f = this.getFeedback(id);
		if(f == null)
			return false;
		em.remove(f);
		return true;
	}
	
	public List<Feedback> getAll() throws Exception {
		List<Feedback> feedbacks = em.createQuery("SELECT f FROM Feedback f", Feedback.class).getResultList();
		return feedbacks;
	}
	
	public List<Feedback> getAll(String phone, int userType)throws Exception{
		List<Feedback> feedbacks;
		String cond = "";
		if(userType == UserType.DRIVER){
			cond = " f.driverPhone =  " + phone;
		}
		else{
			cond = " f.passengerPhone = " + phone;
		}
		feedbacks = em.createQuery("SELECT f FROM Feedback f WHERE " + cond, Feedback.class).getResultList();
		return feedbacks;
	}
	
	public static void main(String[] args) {

	}

}

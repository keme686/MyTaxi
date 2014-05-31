package com.awudima.mytaxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.awudima.mytaxi.model.Favorite;
/**
 * 
 * @author kemele
 *
 */
public class FavoritesDAO {

	private EntityManager em;
	private static FavoritesDAO favoritesDAO =new FavoritesDAO();
	
	public FavoritesDAO() {
		em = Persistence.createEntityManagerFactory("mytaxiModel").createEntityManager();
	}
	
	public static FavoritesDAO getInstance(){
		return favoritesDAO;
	}
	
	public Favorite addFavorite(Favorite favorite)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(favorite);
		tx.commit();
		return favorite;
	}
	
	public Favorite update(Favorite favorite) throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(favorite);
		tx.commit();
		return favorite;
	}
	
	public Favorite getFavorite(int id)throws Exception{
		Favorite f = em.find(Favorite.class, id);
		return f;
	}
	
	public boolean delete(int id)throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Favorite f = this.getFavorite(id);
		if(f == null)
			return false;
		em.remove(f);
		return true;
	}
	public List<Favorite> getAll()throws Exception{
		List<Favorite> favorites = em.createQuery("SELECT f FROM Favorite f", Favorite.class).getResultList();
		return favorites;
	}
	
	public List<Favorite> getAll(String phone) throws Exception{
		List<Favorite> favorites = em.createQuery("SELECT f FROM Favorite f WHERE f.passengerPhone =" +phone, Favorite.class).getResultList();
		return favorites;
		
	}
	
	public static void main(String[] args) {

	}

}

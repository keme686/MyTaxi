/**
 * 
 */
package com.awudima.mytaxi.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.awudima.mytaxi.dao.FavoritesDAO;
import com.awudima.mytaxi.model.Favorite;

/**
 * @author kemele
 *
 */
@Path("/favorite")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class FavoriteData {

	FavoritesDAO favDao = new FavoritesDAO();
	
	@POST
	public Favorite addFavorite(Favorite favorite){
		try{
			return favDao.addFavorite(favorite);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public Favorite updateFavorite(Favorite favorite){
		try{
			return favDao.update(favorite);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	public String deleteFavorite(@PathParam("id")int id){
		try{
			return favDao.delete(id)+"";
		}catch(Exception e){
			e.printStackTrace();
			return false+"";
		}
	}
	
	@GET
	@Path("{id}")
	public Favorite getFavorite(@PathParam("id")int id){
		try{
			return favDao.getFavorite(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
/*	@GET
	@Path("all")
	public List<Favorite> getAll(){
		try{
			return favDao.getAll();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}*/
	
	@GET
	@Path("all")
	public List<Favorite> getAll(@QueryParam("phone") String phone){
		try{
			return favDao.getAll(phone);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}

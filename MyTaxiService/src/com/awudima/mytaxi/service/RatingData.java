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

import com.awudima.mytaxi.dao.RatingDAO;
import com.awudima.mytaxi.model.Rating;

/**
 * @author kemele
 *
 */
@Path("/rating")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class RatingData {

	RatingDAO rateDao = new RatingDAO();
	
	@POST
	public Rating addRating(Rating rating){
		try{
			return rateDao.addRating(rating);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public Rating updateRating(Rating rating){
		try{
			return rateDao.update(rating);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	public String deleteRating(@PathParam("id")int id){
		try{
			return rateDao.delete(id) +"";
		}catch(Exception e){
			e.printStackTrace();
			return false +"";
		}
	}
	
	@GET
	@Path("{id}")
	public Rating getRating(@PathParam("id")int id){
		try{
			return rateDao.getRating(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all")
	public List<Rating> getAll(){
		try{
			return rateDao.getAll();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all/{usertype}")
	public List<Rating> getAll(@PathParam("usertype")int userType, @QueryParam("phone")String phone){
		try{
			return rateDao.getRating(phone, userType);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//add rating calculation
	
	//add rating total for each usertype
}

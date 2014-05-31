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

import com.awudima.mytaxi.dao.FeedbackDAO;
import com.awudima.mytaxi.model.Feedback;

/**
 * @author kemele
 *
 */
@Path("/feedback")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class FeedbackData {

	FeedbackDAO feedDao = new FeedbackDAO();
	
	@POST
	public Feedback addFeedback(Feedback feedback){
		try{
			return feedDao.addFeedback(feedback);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public Feedback updateFeedback(Feedback feedback){
		try{
			return feedDao.update(feedback);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	public String deleteFeedback(@PathParam("id") int id){
		try{
			return "" + feedDao.delete(id);
		}catch(Exception e){
			e.printStackTrace();
			return false+"";
		}
	}
	
	@GET
	@Path("{id}")
	public Feedback getFeedback(@PathParam("id")int id){
		try{
			return feedDao.getFeedback(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all")
	public List<Feedback> getAll(){
		try{
			return feedDao.getAll();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all/{usertype}")
	public List<Feedback> getAll(@PathParam("usertype")int type, @QueryParam("phone")String phone){
		try{
			return feedDao.getAll(phone, type);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

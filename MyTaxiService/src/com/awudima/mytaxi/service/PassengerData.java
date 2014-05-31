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

import com.awudima.mytaxi.dao.PassengerDAO;
import com.awudima.mytaxi.model.Passenger;

/**
 * @author kemele
 *
 */
@Path("/passenger")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class PassengerData {

	PassengerDAO passDao = new PassengerDAO();
	
	@POST
	public Passenger addPassenger(Passenger passenger){
		try{
			return passDao.addPassenger(passenger);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public Passenger updatePassenger(Passenger passenger){
		try{
			return passDao.update(passenger);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	public String deletePassenger(@QueryParam("phone")String phone){
		try{
			return ""+ passDao.delete(phone);
		}catch(Exception e){
			e.printStackTrace();
			return false+"";
		}
	}
	
	@GET
	public Passenger getPassenger(@QueryParam("phone")String phone){
		try{
			return passDao.getPassenger(phone);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all")
	public List<Passenger> getAll(){
		try{
			return passDao.getAll();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}

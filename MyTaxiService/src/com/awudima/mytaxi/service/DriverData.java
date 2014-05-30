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
import javax.ws.rs.core.MediaType;

import com.awudima.mytaxi.dao.DriverDAO;
import com.awudima.mytaxi.model.Driver;

@Path("/driver")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class DriverData {

	private DriverDAO ddao = DriverDAO.getInstance();
	
	@POST
	public Driver addDriver(Driver driver){
		try{
			return ddao.addDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	public Driver update(Driver driver){
		try{
			return ddao.update(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@GET
	@Path("{phone}")
	public Driver getDriver(@PathParam("phone")String phoneNumber){
		try{
			return ddao.getDriver(phoneNumber);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@DELETE
	@Path("{phone}")
	public boolean delete(@PathParam("phone")String phoneNumber){
		try{
			return ddao.delete(phoneNumber);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@GET
	@Path("/all")
	public List<Driver> getAll(){
		try{
			return ddao.getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

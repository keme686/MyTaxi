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

import com.awudima.mytaxi.dao.TaxiDAO;
import com.awudima.mytaxi.model.Taxi;

@Path("/taxi")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class TaxiData {

	private TaxiDAO taxiDao = TaxiDAO.getInstance();
	
	/**
	 * 
	 * @param taxi
	 * @return
	 */
	@POST
	@Path("add")
	public Taxi addTaxi(Taxi taxi){
		try{
		 return	taxiDao.addTaxi(taxi);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param taxiId
	 * @param taxi
	 * @return
	 */
	@PUT
	public Taxi update(Taxi taxi){
		try{
			return taxiDao.update(taxi);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("{id}")
	public Taxi getTaxi(@PathParam("id")int id){
		try{
			return taxiDao.getTaxi(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("{id}")
	public String delete(@PathParam("id")int id){
		try{
			return taxiDao.delete(id)+"";
		}catch(Exception e){
			e.printStackTrace();
		}
		return false+"";
	}
	
	@GET
	@Path("all")
	public List<Taxi> getAll(){
		try{
			return taxiDao.getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
